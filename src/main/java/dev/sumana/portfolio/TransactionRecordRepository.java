package dev.sumana.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRecordRepository extends JpaRepository<TransactionRecord, Long> {
}
