package com.hei.wallet_spring.Controller;
import com.hei.wallet_spring.Model.Account;
import com.hei.wallet_spring.Service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts() throws SQLException {
        return accountService.findAll();
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) throws SQLException {
        return accountService.save(account);
    }

    @PostMapping("/all")
    public List<Account> createAccounts(@RequestBody List<Account> accounts) throws SQLException {
        return accountService.saveAll(accounts);
    }

    @DeleteMapping
    public Account deleteAccount(@RequestBody Account account) throws SQLException {
        return accountService.delete(account);
    }
}
