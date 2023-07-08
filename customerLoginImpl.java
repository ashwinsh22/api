package com.scb.personalBanking.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.personalBanking.entity.Customer;
import com.scb.personalBanking.repository.CustomerRepository;
import com.scb.personalBanking.service.customerLogin;

@Service
public class customerLoginImpl implements customerLogin{

@Autowired
private CustomerRepository custRepo;

@Override
public Customer getByCustid(long custid) {
	
	Customer customer = this.custRepo.findById(custid).get();	
	return customer;
}

@Override
public List<Customer> findAll() {
	List<Customer> c = new ArrayList<>();
	c = this.custRepo.findAll();
	return c;
}

}
