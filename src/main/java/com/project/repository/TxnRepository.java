package com.project.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.entity.Txn;

public interface TxnRepository extends JpaRepository<Txn, Long>{
	
	@Query("SELECT t FROM Txn t WHERE t.user.userId IN :userIds")
    List<Txn> findByUser_IdIn(@Param("userIds") List<Long> userIds);
    
	@Query("SELECT t FROM Txn t WHERE t.user.id = :userId AND t.amount BETWEEN :minAmount AND :maxAmount")
    List<Txn> findByUser_UserIdAndAmountBetween(@Param("userId") Long userId, 
            @Param("minAmount") BigDecimal minAmount, 
            @Param("maxAmount") BigDecimal maxAmount);
    
}
