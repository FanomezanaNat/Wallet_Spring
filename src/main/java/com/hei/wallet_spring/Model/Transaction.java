package com.hei.wallet_spring.Model;


import java.sql.Timestamp;
import java.util.UUID;


public class Transaction {
    private UUID id;
    private Timestamp transactionDate;
    private Double amount;
    private UUID category;
    private UUID account;

    public Transaction(UUID id, Timestamp transactionDate, Double amount, UUID category, UUID account) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.category = category;
        this.account = account;
    }

    public Transaction(Timestamp transactionDate, Double amount, UUID category, UUID account) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.category = category;
        this.account = account;
    }

    public Transaction() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
    }

    public UUID getAccount() {
        return account;
    }

    public void setAccount(UUID account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transactionDate=" + transactionDate +
                ", amount=" + amount +
                ", category=" + category +
                ", account=" + account +
                '}';
    }
}
