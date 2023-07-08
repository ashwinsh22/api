package com.scb.personalBanking.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.personalBanking.entity.Customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/home")
@Tag(name="home", description = "Welcome to Standard Chartered Personal Banking")
public class HomeController {


	
	@GetMapping("/info")
	@Operation(summary = "home", description = "Default response")
	public String home() {
		
		return "Standard Chartered plc is a British multinational bank with operations in consumer, corporate and institutional banking, and treasury services. Despite being headquartered in the United Kingdom, it does not conduct retail banking in the UK, and around 90% of its profits come from Asia, Africa, and the Middle East. CEO: Simon Cooper (2018–), Bill Winters (10 Jun 2015–), Founders: Royal charter, Chartered Bank of India, Australia and China, Standard Bank, Founded: 1969, London, United Kingdom, Headquarters: London, England, UK, Owner: Temasek Holdings (17%), Traded as: LSE: STAN; SEHK: 2888; NSE: STAN; FTSE 100 component (LSE)";
	}
		

	/*
	@GetMapping("/login")
	@Operation(summary = "login", description = "Please login with username and password")
	public String greet() {
		return "Welcome to Standard Chartered Personal Banking Login Page. Please enter customer id and IPIN.. Date -"+LocalDateTime.now();
	}
	
	*/

}
