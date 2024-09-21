package com.project.entity;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;

import jakarta.persistence.*;

@Entity
@Table(name = "User_txn_tbl")
public class Txn {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txnId;
    
    private String txnUuid;
    private String service;
    
    @DecimalMin(value = "0.0", message = "Amount must not be less than 0")
    private BigDecimal amount;
    
    private BigDecimal gst;
    private BigDecimal commission;
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getTxnUuid() {
		return txnUuid;
	}

	public void setTxnUuid(String txnUuid) {
		this.txnUuid = txnUuid;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getGst() {
		return gst;
	}

	public void setGst(BigDecimal gst) {
		this.gst = gst;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    

}
