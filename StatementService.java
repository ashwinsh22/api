package com.scb.personalBanking.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.scb.personalBanking.entity.Statement;
import com.scb.personalBanking.exception.RecordNotCreatedException;
import com.scb.personalBanking.exception.RecordNotDeletedException;
import com.scb.personalBanking.exception.RecordNotFoundException;
import com.scb.personalBanking.exception.RecordNotUpdatedException;

public interface StatementService {
	Statement createStatement(Statement newStatement) throws RecordNotCreatedException;
	Statement getByURN(long transUrn) throws RecordNotFoundException;
	List<Statement> getAllStatements();
	Statement updateStatement(Statement modifiedStatement) throws RecordNotUpdatedException;
	String deleteStatementByURN(long transUrn) throws RecordNotDeletedException;
	//Statement searchByURN(long transUrn);
	List<Statement> getStatementInRange(Date begin, Date end);
}
