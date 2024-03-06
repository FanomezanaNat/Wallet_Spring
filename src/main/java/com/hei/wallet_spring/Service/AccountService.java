package com.hei.wallet_spring.Service;

import com.hei.wallet_spring.Model.Account;
import com.hei.wallet_spring.Repository.AccountDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private  AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    public List<Account> saveAll(List<Account> toSave) {
        return accountDAO.saveAll(toSave);
    }

    public Account save(Account toSave) {
        return accountDAO.save(toSave);
    }

    public Account delete(Account toDelete) {
        return accountDAO.delete(toDelete);
    }

}
