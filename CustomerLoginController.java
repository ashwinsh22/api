package com.scb.personalBanking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.personalBanking.config.ApiErrorResponse;
import com.scb.personalBanking.config.ApiSuccessResponse;
import com.scb.personalBanking.entity.Customer;
import com.scb.personalBanking.entity.Login;
import com.scb.personalBanking.service.customerLogin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/personal-banking")
@Tag(name = "customer", description = "Account Login")
public class CustomerLoginController {

	
	@Autowired
	private customerLogin customerLog;
	
	
	//@GetMapping("/login/{custid}/{password}")
	@PostMapping("/login/")
	@Operation(summary = "login", description = "Post login info")
	/*public ResponseEntity<?> getByCustid(@PathVariable long custid, @PathVariable String password) {
	*/
	public ResponseEntity<?> getByCustid(@RequestBody Login logininfo){
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		long custid = logininfo.getCustomer_id();
		String password = logininfo.getPassword();
		
		try {
			Customer c = this.customerLog.getByCustid(custid);	
			
			ApiSuccessResponse response = new ApiSuccessResponse();
			
			//if(c.getPassword().equals(password)) --earlier case; both were raw passwords
			
			if(encoder.matches(password, c.getPassword())) {
				response.setMessage("Login Successful");
				response.setBody(c);
				response.setStatusCode(HttpStatus.FOUND);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}
			else {
				response.setMessage("Incorrect Password");
				response.setBody(null);
				response.setStatusCode(HttpStatus.UNAUTHORIZED);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
		}
		catch(Exception e) {
			ApiErrorResponse resp = new ApiErrorResponse();
			resp.setMessage("User Not Found");
			resp.setCause(e);
			resp.setStatusCode(HttpStatus.NOT_FOUND);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
		}
		
		
		
	}
	
	/*
	@GetMapping("/allCust")
	@Operation(summary = "get-all-customer", description = "Get All Customers")
	public List<Customer> getAllCustomers()  {
		
		return this.customerLog.findAll();
		
	}*/
	
	
}
