package com.transaction.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id
    private Long transactionId;
    private Double amount;
    private String type;
    private String parentId;

    public Transaction(Long transactionId, Double amount, String type, String parentId) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.parentId = parentId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

}