package com.scb.personalBanking.service;

import com.scb.personalBanking.entity.Customer;

import antlr.collections.List;

public interface customerRegistration {

	Customer createCustomer(Customer newCustomer);
	//List searchByAccount(int acct_number);
}
