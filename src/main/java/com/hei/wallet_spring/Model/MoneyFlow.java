package com.hei.wallet_spring.Model;



import java.util.UUID;


public class MoneyFlow {
    private UUID idAccount;
    private Double totalEntrance;
    private Double totalExit;

    public MoneyFlow(Double totalEntrance, Double totalExit) {
        this.totalEntrance = totalEntrance;
        this.totalExit = totalExit;
    }

    public MoneyFlow(UUID idAccount, Double totalEntrance, Double totalExit) {
        this.idAccount = idAccount;
        this.totalEntrance = totalEntrance;
        this.totalExit = totalExit;
    }
    public MoneyFlow() {

    }

    public UUID getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(UUID idAccount) {
        this.idAccount = idAccount;
    }

    public Double getTotalEntrance() {
        return totalEntrance;
    }

    public void setTotalEntrance(Double totalEntrance) {
        this.totalEntrance = totalEntrance;
    }

    public Double getTotalExit() {
        return totalExit;
    }

    public void setTotalExit(Double totalExit) {
        this.totalExit = totalExit;
    }


    @Override
    public String toString() {
        return "MoneyFlow{" +
                "idAccount=" + idAccount +
                ", totalEntrance=" + totalEntrance +
                ", totalExit=" + totalExit +
                '}';
    }
}
