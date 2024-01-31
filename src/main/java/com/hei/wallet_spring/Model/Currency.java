package com.hei.wallet_spring.Model;



import java.util.Objects;
import java.util.UUID;

public class Currency {
    private UUID id;
    private String name;
    private String code;

    public Currency(UUID id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
    public Currency( String name, String code) {

        this.name = name;
        this.code = code;
    }  public Currency() {
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency currency)) return false;

        if (!Objects.equals(id, currency.id)) return false;
        if (!Objects.equals(name, currency.name)) return false;
        return Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
