package com.hei.wallet_spring.Service;

import com.hei.wallet_spring.Model.Transaction;
import com.hei.wallet_spring.Repository.TransactionDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private TransactionDAO transactionDAO;

    public TransactionService(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public List<Transaction> findAll() {
        return transactionDAO.findAll();
    }

    public List<Transaction> saveAll(List<Transaction> toSave) {
        return transactionDAO.saveAll(toSave);
    }

    public Transaction save(Transaction toSave) {
        return transactionDAO.save(toSave);
    }

    public Transaction delete(Transaction toDelete) {
        return transactionDAO.delete(toDelete);
    }
}
