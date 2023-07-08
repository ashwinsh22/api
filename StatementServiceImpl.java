package com.scb.personalBanking.service.Impl;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.scb.personalBanking.entity.Statement;
import com.scb.personalBanking.exception.RecordNotCreatedException;
import com.scb.personalBanking.exception.RecordNotDeletedException;
import com.scb.personalBanking.exception.RecordNotFoundException;
import com.scb.personalBanking.exception.RecordNotUpdatedException;
import com.scb.personalBanking.repository.StatementRepository;
import com.scb.personalBanking.service.StatementService;

@Service
public class StatementServiceImpl implements StatementService{

	@Autowired
	private StatementRepository stateRepo;
	
	@Override
	public Statement createStatement(Statement newStatement) throws RecordNotCreatedException {
		try {
			if(!this.stateRepo.existsById(newStatement.getTransUrn() )) {
				Statement statement = this.stateRepo.save(newStatement);
				return statement;
			} else {
				throw new RecordNotCreatedException("Failed. Transaction URN already exists.");
			}
		}catch(DataAccessException e) {
			String message ="Statement not created. Check details.";
			throw new RecordNotCreatedException(message, e);
		}
	}
	
	@Override
	public Statement getByURN(long transUrn) throws RecordNotFoundException {
		try {
			Statement statement = this.stateRepo.findById(transUrn).get();
			return statement;
		} catch(NoSuchElementException e) {
			String message = "No such transaction with URN :" + transUrn;
			throw new RecordNotFoundException(message, e);
		}	
	}

	@Override
	public List<Statement> getAllStatements() {
		return this.stateRepo.findAll();
	}

	@Override
	public Statement updateStatement(Statement modifiedStatement) throws RecordNotUpdatedException {
		if(this.stateRepo.existsById(modifiedStatement.getTransUrn() )) {
			try {
				Statement stt = this.stateRepo.save(modifiedStatement);
				return stt;
			} catch(DataAccessException e) {
				String message = "Statement not updated. Check details";
				throw new RecordNotUpdatedException(message, e);
			}
		} else {
			throw new RecordNotUpdatedException("Update Failed. Transaction URN does not exist.");
		} 
	}

	
	@Override
	public String deleteStatementByURN(long transUrn) throws RecordNotDeletedException  {
		if(this.stateRepo.existsById(transUrn)) {
			
			try {
				this.stateRepo.deleteById(transUrn);				
				return "Statement deleted successfully";
			} catch (EmptyResultDataAccessException e) {
				String message = "Delete operation failed. Check details";
				throw new RecordNotDeletedException(message, e);

			}
			
		} else {
			String message = "Invalid id: Delete operation failed";
			throw new RecordNotDeletedException(message);
			
		}
		
	}
	


	@Override
	public List<Statement> getStatementInRange(Date date_from, Date date_to) {
		List<Statement> inRange = new ArrayList<>();
		List<Statement> allStts = new ArrayList<>();
		allStts = this.stateRepo.findAll();

		for(Statement stt: allStts) {
			Date txnDate = stt.getTransaction_date();
			if(txnDate.after(date_from) && txnDate.before(date_to)) {
				inRange.add(stt);
			}
		}
				
		return inRange;
	}

}


