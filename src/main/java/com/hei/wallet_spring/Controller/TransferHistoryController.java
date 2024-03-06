package com.hei.wallet_spring.Controller;
import com.hei.wallet_spring.Model.TransferHistory;
import com.hei.wallet_spring.Service.TransferHistoryService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/transferHistory")
public class TransferHistoryController {
    private final TransferHistoryService transferHistoryService;

    public TransferHistoryController(TransferHistoryService transferHistoryService) {
        this.transferHistoryService = transferHistoryService;
    }

    @GetMapping
    public List<TransferHistory> getAllTransferHistories() throws SQLException {
        return transferHistoryService.findAll();
    }

    @PostMapping
    public TransferHistory createTransferHistory(@RequestBody TransferHistory transferHistory) throws SQLException {
        return transferHistoryService.save(transferHistory);
    }

    @PostMapping("/all")
    public List<TransferHistory> createTransferHistories(@RequestBody List<TransferHistory> transferHistories) throws SQLException {
        return transferHistoryService.saveAll(transferHistories);
    }

    @DeleteMapping
    public TransferHistory deleteTransferHistory(@RequestBody TransferHistory transferHistory) throws SQLException {
        return transferHistoryService.delete(transferHistory);
    }
}
