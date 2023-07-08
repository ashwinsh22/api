package com.scb.personalBanking.controller;


import java.io.Console;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scb.personalBanking.config.ApiErrorResponse;
import com.scb.personalBanking.config.ApiSuccessResponse;
import com.scb.personalBanking.entity.Statement;
import com.scb.personalBanking.exception.RecordNotCreatedException;
import com.scb.personalBanking.exception.RecordNotDeletedException;
import com.scb.personalBanking.exception.RecordNotFoundException;
import com.scb.personalBanking.exception.RecordNotUpdatedException;
import com.scb.personalBanking.service.StatementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/statement")
@Tag(name = "statement", description = "APIs related to Bank Statements")

public class StatementController {
	
	public static String newline = System.getProperty("line.separator");
	
	@Autowired
	private StatementService sttService;
	
	@PostMapping("/create")
	@Operation(summary = "create-statement", description = "Create new statement")
	public ResponseEntity<?> createStatement(@RequestBody Statement statement) {
		try {
			ApiSuccessResponse response = new ApiSuccessResponse();
			Statement stt = this.sttService.createStatement(statement);
			
			response.setMessage("Statement created");
			response.setBody(stt);
			response.setStatusCode(HttpStatus.CREATED);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (RecordNotCreatedException e) {
			// e.printStackTrace();
			ApiErrorResponse response = new ApiErrorResponse();
			response.setMessage(e.getMessage());
			if(e.getCause() != null) {
				response.setCause(e.getCause().getMessage());
			} else {
				response.setCause("Cause not applicable");
			}
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@GetMapping("/viewAll")
	@Operation(summary = "get-all-statements", description = "Get all statements")
	public ResponseEntity<?> getStatements() {
		ApiSuccessResponse response = new ApiSuccessResponse();
		List<Statement> stts = (List<Statement>) this.sttService.getAllStatements();
				
		response.setMessage("Statements found - "+ stts.size());
		response.setBody(stts);
		response.setStatusCode(HttpStatus.FOUND);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	/*
	@GetMapping("/range")
	public @ResponseBody ResponseEntity<?> getStatementsInRange(@DateTimeFormat(pattern = "dd-M-yyyy'T'hh:mm:ss") @RequestParam Date begin,
	        @DateTimeFormat(pattern = "dd-M-yyyy'T'hh:mm:ss") @RequestParam Date end, @RequestParam Integer capacity) {
		ApiSuccessResponse response = new ApiSuccessResponse();
		List<Statement> stts = this.sttService.getStatementInRange(begin, end);
		response.setMessage("Statements found - "+ stts.size());
		response.setBody(stts);
		response.setStatusCode(HttpStatus.FOUND);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	*/
	/*
	@GetMapping("/users")
	public String getUsers(@RequestParam String date_from, @RequestParam String date_to) {
		String date = "21-05-2023";
		if(date.compareToIgnoreCase(date_from)>=0 && date.compareToIgnoreCase(date_to)<=0)
			return "In range";
		else
			return "Not in range";
		
	}
	*/
	/*
	@GetMapping("/users")
	public String getUsers(@RequestParam
							  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
							  LocalDate date_from, 
							  @RequestParam
							  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)	
							  LocalDate date_to) {
		LocalDate txnDate = LocalDate.of(2018, Month.OCTOBER, 12);
		if(txnDate.isAfter(date_from) && txnDate.isBefore(date_to))
			return "In range";
		else
			return "Not in range";

		
	}*/
	
	@GetMapping("/range")
	@Operation(summary = "get-statements-in-range", description = "Get statements within range of dates")
	public @ResponseBody ResponseEntity<?> getStatementsInRange(@RequestParam
																@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
																Date date_from, 
																@RequestParam 
																@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
																Date date_to) {
		ApiSuccessResponse response = new ApiSuccessResponse();
		List<Statement> stts = this.sttService.getStatementInRange(date_from, date_to);
		response.setMessage("Statements found - "+ stts.size());
		response.setBody(stts);
		response.setStatusCode(HttpStatus.FOUND);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/{transUrn}")
	@Operation(summary = "get-transaction-by-URN", description = "Get Transaction by URN")
	public ResponseEntity<?> getById(@PathVariable long transUrn) {
		
		try {
			ApiSuccessResponse response = new ApiSuccessResponse();
			Statement stts = this.sttService.getByURN(transUrn);
			
			response.setMessage("Statement found.");
			response.setBody(stts);
			response.setStatusCode(HttpStatus.FOUND);

			return ResponseEntity.status(HttpStatus.OK).body(response);
		}  catch (RecordNotFoundException e) {			
			ApiErrorResponse response = new ApiErrorResponse();
			response.setMessage(e.getMessage());
			if(e.getCause() != null) {
				response.setCause(e.getCause().getMessage());
			} else {
				response.setCause("Cause not applicable");
			}
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}
	

	@PutMapping("/modify")
	@Operation(summary = "update-transaction", description = "Modify the existing transaction")
	public ResponseEntity<?> updateEmployee(@RequestBody Statement modifiedStatement) {
		try {
			ApiSuccessResponse response = new ApiSuccessResponse();
			Statement stt = this.sttService.updateStatement(modifiedStatement);
			System.out.println(modifiedStatement);
			response.setMessage("Statement updated.");
			response.setBody(stt);
			response.setStatusCode(HttpStatus.FOUND);

			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (RecordNotUpdatedException e) {
			// e.printStackTrace();

			ApiErrorResponse response = new ApiErrorResponse();

			response.setMessage(e.getMessage());
			if(e.getCause() != null) {
				response.setCause(e.getCause().getMessage());
			} else {
				response.setCause("Cause not applicable");
			}
			response.setStatusCode(HttpStatus.BAD_REQUEST);

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@DeleteMapping("/{transUrn}")
	@Operation(summary = "delete-statement", description = "Delete statement by URN")
	public ResponseEntity<?> deleteEmployee(@PathVariable long transUrn) {
		try {
			ApiSuccessResponse response = new ApiSuccessResponse();

			String message = this.sttService.deleteStatementByURN(transUrn);

			response.setMessage("Statement deleted.");
			response.setBody(message);
			response.setStatusCode(HttpStatus.ACCEPTED);

			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (RecordNotDeletedException e) {
			//e.printStackTrace();

			ApiErrorResponse response = new ApiErrorResponse();

			response.setMessage(e.getMessage());
			if(e.getCause() != null) {
				response.setCause(e.getCause().getMessage());
			} else {
				response.setCause("Cause not applicable");
			}
			response.setStatusCode(HttpStatus.BAD_REQUEST);

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	
	
}



