package com.transaction.demo.model;

public class TransactionSumResponse {
    private Double sum;

    public TransactionSumResponse(Double sum) {
        this.sum = sum;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
