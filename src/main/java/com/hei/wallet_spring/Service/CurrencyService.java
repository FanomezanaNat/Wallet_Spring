package com.hei.wallet_spring.Service;

import com.hei.wallet_spring.Model.Currency;
import com.hei.wallet_spring.Repository.CurrencyDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    private CurrencyDAO currencyDAO;

    public CurrencyService(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    public List<Currency> findAll() {
        return currencyDAO.findAll();
    }

    public List<Currency> saveAll(List<Currency> toSave) {
        return currencyDAO.saveAll(toSave);
    }

    public Currency save(Currency toSave) {
        return currencyDAO.save(toSave);
    }

    public Currency delete(Currency toDelete) {
        return currencyDAO.delete(toDelete);
    }
}
