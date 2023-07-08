package com.scb.personalBanking.service;

import java.util.List;

import com.scb.personalBanking.entity.AccountTransactions;
import com.scb.personalBanking.entity.Statement;
import com.scb.personalBanking.entity.TransferFunds;

public interface TransferFundsService {

	TransferFunds createFundsTrasfer(TransferFunds newFundsTransfer);
	List<TransferFunds> getAllTransferFunds();

}
