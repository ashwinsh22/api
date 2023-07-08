package com.scb.personalBanking.entity;

import io.swagger.v3.oas.annotations.Parameter;

public class Login {

	private long customer_id;
	private String password;
	
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
