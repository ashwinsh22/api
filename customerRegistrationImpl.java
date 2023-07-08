package com.scb.personalBanking.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.personalBanking.entity.Customer;
import com.scb.personalBanking.repository.CustomerRepository;
import com.scb.personalBanking.service.customerRegistration;

@Service
public class customerRegistrationImpl implements customerRegistration {
	
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public Customer createCustomer(Customer newCustomer) {
		
		Customer customer = this.custRepo.save(newCustomer);
		
		return customer;
	}
	
	//@Override
	//public antlr.collections.List searchByAccount(int acct_number) {
		
		//List<Customer> customer = this.custRepo.findByAcctNumberNative(acct_number);
		//return (antlr.collections.List) customer;
	//}


}
