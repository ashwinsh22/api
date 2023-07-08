package com.scb.personalBanking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.ComponentScan;
import com.scb.personalBanking.entity.Customer;
import com.scb.personalBanking.service.customerRegistration;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/insta-account-opening")
@Tag(name = "customer", description = "New insta account opening")
public class CustomerController {

	@Autowired
	private customerRegistration customerReg;
	
	
	@PostMapping("/")
	@Operation(summary = "new customer", description = "Please fill in the mandatory information")
	public String createCustomer(@RequestBody Customer customer) {
		Customer cust = this.customerReg.createCustomer(customer);
        return "Account details have been received successfully, after thorough verification, Account number will be sent to your registered email id in 24 hours";

		
	}
}
