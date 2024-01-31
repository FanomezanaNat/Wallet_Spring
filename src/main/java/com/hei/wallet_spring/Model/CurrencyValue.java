package com.hei.wallet_spring.Model;


import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;


public class CurrencyValue {
    private UUID id;
    private UUID sourceCurrencyId;
    private UUID destinationCurrencyId;
    private double amount;
    private Timestamp dateEffect;

    public CurrencyValue(UUID id, UUID sourceCurrencyId, UUID destinationCurrencyId, double amount, Timestamp dateEffect) {
        this.id = id;
        this.sourceCurrencyId = sourceCurrencyId;
        this.destinationCurrencyId = destinationCurrencyId;
        this.amount = amount;
        this.dateEffect = dateEffect;
    }

    public CurrencyValue(UUID sourceCurrencyId, UUID destinationCurrencyId, double amount, Timestamp dateEffect) {
        this.sourceCurrencyId = sourceCurrencyId;
        this.destinationCurrencyId = destinationCurrencyId;
        this.amount = amount;
        this.dateEffect = dateEffect;
    }

    public CurrencyValue() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSourceCurrencyId() {
        return sourceCurrencyId;
    }

    public void setSourceCurrencyId(UUID sourceCurrencyId) {
        this.sourceCurrencyId = sourceCurrencyId;
    }

    public UUID getDestinationCurrencyId() {
        return destinationCurrencyId;
    }

    public void setDestinationCurrencyId(UUID destinationCurrencyId) {
        this.destinationCurrencyId = destinationCurrencyId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getDateEffect() {
        return dateEffect;
    }

    public void setDateEffect(Timestamp dateEffect) {
        this.dateEffect = dateEffect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyValue that)) return false;

        if (Double.compare(amount, that.amount) != 0) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(sourceCurrencyId, that.sourceCurrencyId))
            return false;
        if (!Objects.equals(destinationCurrencyId, that.destinationCurrencyId))
            return false;
        return Objects.equals(dateEffect, that.dateEffect);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sourceCurrencyId != null ? sourceCurrencyId.hashCode() : 0);
        result = 31 * result + (destinationCurrencyId != null ? destinationCurrencyId.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dateEffect != null ? dateEffect.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyValue{" +
                "id=" + id +
                ", sourceCurrencyId=" + sourceCurrencyId +
                ", destinationCurrencyId=" + destinationCurrencyId +
                ", amount=" + amount +
                ", dateEffect=" + dateEffect +
                '}';
    }
}
