package com.hei.wallet_spring.Model;


import java.sql.Timestamp;
import java.util.UUID;


public class TransferHistory {
    private UUID id;
    private UUID debitTransactionId;
    private UUID creditTransactionId;
    private Timestamp transferDate;

    public TransferHistory(UUID debitTransactionId, UUID creditTransactionId, Timestamp transferDate) {
        this.debitTransactionId = debitTransactionId;
        this.creditTransactionId = creditTransactionId;
        this.transferDate = transferDate;
    }

    public TransferHistory(UUID id, UUID debitTransactionId, UUID creditTransactionId, Timestamp transferDate) {
        this.id = id;
        this.debitTransactionId = debitTransactionId;
        this.creditTransactionId = creditTransactionId;
        this.transferDate = transferDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getDebitTransactionId() {
        return debitTransactionId;
    }

    public void setDebitTransactionId(UUID debitTransactionId) {
        this.debitTransactionId = debitTransactionId;
    }

    public UUID getCreditTransactionId() {
        return creditTransactionId;
    }

    public void setCreditTransactionId(UUID creditTransactionId) {
        this.creditTransactionId = creditTransactionId;
    }

    public Timestamp getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Timestamp transferDate) {
        this.transferDate = transferDate;
    }

    @Override
    public String toString() {
        return "TransferHistory{" +
                "id=" + id +
                ", debitTransactionId=" + debitTransactionId +
                ", creditTransactionId=" + creditTransactionId +
                ", transferDate=" + transferDate +
                '}';
    }
}
