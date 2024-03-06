package com.hei.wallet_spring.Controller;

import com.hei.wallet_spring.Model.Transaction;
import com.hei.wallet_spring.Service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() throws SQLException {
        return transactionService.findAll();
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) throws SQLException {
        return transactionService.save(transaction);
    }

    @PostMapping("/all")
    public List<Transaction> createTransactions(@RequestBody List<Transaction> transactions) throws SQLException {
        return transactionService.saveAll(transactions);
    }

    @DeleteMapping
    public Transaction deleteTransaction(@RequestBody Transaction transaction) throws SQLException {
        return transactionService.delete(transaction);
    }
}
