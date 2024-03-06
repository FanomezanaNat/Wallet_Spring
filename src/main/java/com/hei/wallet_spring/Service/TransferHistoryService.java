package com.hei.wallet_spring.Service;

import com.hei.wallet_spring.Model.TransferHistory;
import com.hei.wallet_spring.Repository.TransferHistoryDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferHistoryService {
    private TransferHistoryDAO transferHistoryDAO;

    public TransferHistoryService(TransferHistoryDAO transferHistoryDAO) {
        this.transferHistoryDAO = transferHistoryDAO;
    }

    public List<TransferHistory> findAll() {
        return transferHistoryDAO.findAll();
    }

    public List<TransferHistory> saveAll(List<TransferHistory> toSave) {
        return transferHistoryDAO.saveAll(toSave);
    }

    public TransferHistory save(TransferHistory toSave) {
        return transferHistoryDAO.save(toSave);
    }

    public TransferHistory delete(TransferHistory toDelete) {
        return transferHistoryDAO.delete(toDelete);
    }
}
