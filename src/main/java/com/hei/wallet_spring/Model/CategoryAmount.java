package com.hei.wallet_spring.Model;



import java.util.Objects;
import java.util.UUID;


public class CategoryAmount {
    private UUID idAccount;
    private String categoryName;
    private Double amount;

    public CategoryAmount(UUID idAccount, String categoryName, Double amount) {
        this.idAccount = idAccount;
        this.categoryName = categoryName;
        this.amount = amount;
    }
    public CategoryAmount(String categoryName, Double amount) {
        this.categoryName = categoryName;
        this.amount = amount;
    }
    public CategoryAmount(){

    }


    public UUID getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(UUID idAccount) {
        this.idAccount = idAccount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryAmount that)) return false;

        if (!Objects.equals(idAccount, that.idAccount)) return false;
        if (!Objects.equals(categoryName, that.categoryName)) return false;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        int result = idAccount != null ? idAccount.hashCode() : 0;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CategoryAmount{" +
                "idAccount=" + idAccount +
                ", categoryName='" + categoryName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
