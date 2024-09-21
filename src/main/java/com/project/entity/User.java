package com.project.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "User_tbl")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    private String firstName;
    
    private String lastName;
    
    @Column(unique = true)
    private String email;
    
    @Column(unique = true)
    private String phone;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Bank bank;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Txn> txns;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<Txn> getTxns() {
		return txns;
	}

	public void setTxns(List<Txn> txns) {
		this.txns = txns;
	}
    
    
}
