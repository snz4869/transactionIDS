package id.ids.controller;

import id.ids.dto.TransactionResponse;
import id.ids.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);


    @GetMapping
    public ResponseEntity<?> getAllTransactions() {
        try {
            log.info("Fetching all transactions");
            TransactionResponse response = transactionService.getAllTrx();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Internal server error while retrieving all transactions: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable Integer id) {
        try {
            log.info("Fetching transaction with ID: {}", id);
            TransactionResponse response = transactionService.getTrxById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Internal server error while retrieving transaction ID {}: {}", id, e.getMessage(), e);
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        }
    }

}
