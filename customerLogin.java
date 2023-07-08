package com.scb.personalBanking.service;
import java.util.List;

import com.scb.personalBanking.entity.Customer;



public interface customerLogin {

	Customer getByCustid(long custid);
	List<Customer> findAll();
}



