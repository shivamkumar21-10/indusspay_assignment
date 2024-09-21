package com.project.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.entity.Txn;
import com.project.entity.User;
import com.project.repository.TxnRepository;
import com.project.repository.UserRepository;

@Service
public class TxnService {
	
    @Autowired
    private TxnRepository txnRepository;

    @Autowired
    private UserRepository userRepository;

    public void addTxn(Long userId, Txn txn) {
        User user = userRepository.findById(userId)
                                  .orElseThrow(() -> new IllegalArgumentException("User not found"));
        txn.setUser(user);
        txn.setTxnUuid(UUID.randomUUID().toString());
        txnRepository.save(txn);
    }

    public List<Txn> getTxnsByUserIds(List<Long> userIds) {
        if (userIds == null || userIds.isEmpty()) {
            return txnRepository.findAll();
        }
        return txnRepository.findByUser_IdIn(userIds);
    }

    public List<Txn> getTxnsByAmountRange(Long userId, BigDecimal initialRange, BigDecimal finalRange) {
        return txnRepository.findByUser_UserIdAndAmountBetween(userId, initialRange, finalRange);
    }

    public List<Txn> getSortedTxns() {
        return txnRepository.findAll(Sort.by(Sort.Direction.ASC, "amount"));
    }
}
