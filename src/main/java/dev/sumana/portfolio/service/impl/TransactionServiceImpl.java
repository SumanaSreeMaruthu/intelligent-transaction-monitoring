package dev.sumana.portfolio.service.impl;

import dev.sumana.portfolio.TransactionRecord;
import dev.sumana.portfolio.TransactionService;
import dev.sumana.portfolio.service.TransactionServiceOperations;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionServiceOperations {

    private final TransactionService delegate;

    public TransactionServiceImpl(TransactionService delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<TransactionRecord> findAll() {
        return delegate.list();
    }

    @Override
    public TransactionRecord findById(Long id) {
        return delegate.get(id);
    }
}
