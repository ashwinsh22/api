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

import com.scb.personalBanking.config.ApiSuccessResponse;
import com.scb.personalBanking.entity.AccountTransactions;
import com.scb.personalBanking.entity.Statement;
import com.scb.personalBanking.entity.TransferFunds;
import com.scb.personalBanking.service.TransferFundsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/transferFunds")
@Tag(name = "transferFunds", description = "New FundsTransfer")
public class TransferFundsController {

	@Autowired
	private TransferFundsService fundsTransferSrv;
	
	
	
	@PostMapping("/new")
	@Operation(summary = "new fund transfer", description = "Please fill in the details")
	public TransferFunds createFundTransfer(@RequestBody TransferFunds fundTransfer) {
		TransferFunds fndtrnas = this.fundsTransferSrv.createFundsTrasfer(fundTransfer);

		return fndtrnas;
		
	}
	@GetMapping("/allFundTrans")
	@Operation(summary = "view all transfers", description = "View all fund transfer")
	public ResponseEntity<?> getAllTransfers() {
		ApiSuccessResponse response = new ApiSuccessResponse();
		List<TransferFunds> transfers = (List<TransferFunds>) this.fundsTransferSrv.getAllTransferFunds();
				
		response.setMessage("Transfers found - "+ transfers.size());
		response.setBody(transfers);
		response.setStatusCode(HttpStatus.FOUND);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
