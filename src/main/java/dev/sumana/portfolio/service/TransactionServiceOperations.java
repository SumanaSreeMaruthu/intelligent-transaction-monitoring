package dev.sumana.portfolio.service;

import dev.sumana.portfolio.TransactionRecord;
import java.util.List;

public interface TransactionServiceOperations {
    List<TransactionRecord> findAll();
    TransactionRecord findById(Long id);
}
