package dev.sumana.portfolio;

import java.util.List;
import dev.sumana.portfolio.audit.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(readOnly = true)
public class TransactionService {

    private final TransactionRecordRepository repository;
    private final ActivityService activity;
    

    public TransactionService(TransactionRecordRepository repository, ActivityService activity) {
        this.repository = repository;
        this.activity = activity;
        
    }

    public List<TransactionRecord> list() {
        return repository.findAll();
    }

    public TransactionRecord get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found"));
    }

    @Transactional
    public TransactionRecord create(ApiController.Request request) {
        TransactionRecord saved = repository.save(new TransactionRecord(request.transactionId()));
        activity.record("CREATED", "TransactionRecord", saved.getId());
        return saved;
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found");
        }
        repository.deleteById(id);
        activity.record("DELETED", "TransactionRecord", id);
    }

    public List<TransactionRecord> search(String value) {
        if (value == null || value.isBlank()) {
            return repository.findAll();
        }
        return repository.findByRiskLevelIgnoreCase(value.trim());
    }
}
