package com.scb.personalBanking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scb.personalBanking.entity.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scb.personalBanking.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	List<Customer> findByAcctNumber (int acctNumber);
	
	//@Query(value = "select * from customer where acct_number = ?1", nativeQuery = true)
	//List<Customer> findByAcctNumberNative(int acct_number);

}
