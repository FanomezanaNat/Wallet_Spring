package com.hei.wallet_spring.Controller;

import com.hei.wallet_spring.Model.Currency;
import com.hei.wallet_spring.Service.CurrencyService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public List<Currency> getAllCurrencies() throws SQLException {
        return currencyService.findAll();
    }

    @PostMapping
    public Currency createCurrency(@RequestBody Currency currency) throws SQLException {
        return currencyService.save(currency);
    }

    @PostMapping("/all")
    public List<Currency> createCurrencies(@RequestBody List<Currency> currencies) throws SQLException {
        return currencyService.saveAll(currencies);
    }

    @DeleteMapping
    public Currency deleteCurrency(@RequestBody Currency currency) throws SQLException {
        return currencyService.delete(currency);
    }
}
