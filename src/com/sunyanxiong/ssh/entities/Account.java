package com.sunyanxiong.ssh.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sun_account")
public class Account {

	private int id;
	private String username;
	private String balance;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getBalance() {
		return balance;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

}
