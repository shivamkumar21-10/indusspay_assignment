package com.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User_bank_tbl")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;
    
    private String bankName;
    
    private String bankIfsc;
    
    @Column(unique = true)
    private String accountNumber;
    
    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankIfsc() {
		return bankIfsc;
	}

	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}
