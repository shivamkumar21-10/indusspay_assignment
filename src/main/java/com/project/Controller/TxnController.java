package com.project.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Txn;
import com.project.service.TxnService;

@RestController
@RequestMapping("/txn")
public class TxnController {
	
	@Autowired
    private TxnService txnService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addTxn(@PathVariable Long userId, @RequestBody Txn txn) {
        txnService.addTxn(userId, txn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/get/details")
    public ResponseEntity<List<Txn>> getTxnsByUserIds(@RequestBody List<Long> userIds) {
        return ResponseEntity.ok(txnService.getTxnsByUserIds(userIds));
    }

    @GetMapping("/amount/{initial_range}/{final_range}")
    public ResponseEntity<?> getTxnsByAmountRange(@RequestParam Long userId,
                                                  @PathVariable BigDecimal initial_range,
                                                  @PathVariable BigDecimal final_range) {
        List<Txn> txns = txnService.getTxnsByAmountRange(userId, initial_range, final_range);
        if (txns.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(txns, HttpStatus.OK);
    }

    @GetMapping("/sort/amount")
    public ResponseEntity<List<Txn>> getSortedTxns() {
        return ResponseEntity.ok(txnService.getSortedTxns());
    }
}
