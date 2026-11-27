package dev.sumana.portfolio;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class ApiController {

    public record Request(@NotBlank String transactionId) {}

    private final TransactionService service;

    public ApiController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<TransactionRecord> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public TransactionRecord get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionRecord create(@Valid @RequestBody Request request) {
        return service.create(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    @GetMapping("/search")
    public List<TransactionRecord> search(@RequestParam(required = false) String riskLevel) {
        return service.search(riskLevel);
    }
}
