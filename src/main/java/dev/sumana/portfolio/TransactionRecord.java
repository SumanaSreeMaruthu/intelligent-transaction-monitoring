package dev.sumana.portfolio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionId;
    private String riskLevel;

    protected TransactionRecord() {
    }

    public TransactionRecord(String input) {
        this.transactionId = input;
        this.riskLevel = input.toUpperCase().contains("HIGH") ? "REVIEW" : "LOW";
    }

    public Long getId() { return id; }
    public String getTransactionId() { return transactionId; }
    public String getRiskLevel() { return riskLevel; }
}
