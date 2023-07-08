package com.scb.personalBanking.service.Impl;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.personalBanking.entity.AccountTransactions;
import com.scb.personalBanking.entity.Customer;
import com.scb.personalBanking.entity.Statement;
import com.scb.personalBanking.entity.TransferFunds;
import com.scb.personalBanking.repository.AccountTransactionsRepository;
import com.scb.personalBanking.repository.CustomerRepository;
import com.scb.personalBanking.repository.StatementRepository;
import com.scb.personalBanking.repository.TrasferFundsRepository;
import com.scb.personalBanking.service.TransferFundsService;

@Service
public class TransferFundsServiceImpl implements TransferFundsService {
	
	@Autowired
	private TrasferFundsRepository fundTrasnferRepo;
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private AccountTransactionsRepository acctrnRepo;
	@Autowired
	private StatementRepository sttRepo;

	@Override
	public TransferFunds createFundsTrasfer(TransferFunds newFundsTransfer) {
		
		
		Customer custSourceAccount;
		int SrcNewBalance;
		int SrcCurBalance;
		Customer custTargetAccount;
		int TgtNewBalance;
		int TgtCurBalance;
		List<Customer> custSrcAccount = new ArrayList<>();
		List<Customer> custTgtAccount = new ArrayList<>();
		List<AccountTransactions> acctTransactions = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		String transferRefKey  = "REF-" + dateFormat.format(new Date());

		
		//Update Source Account
		
		custSrcAccount = this.custRepo.findByAcctNumber(newFundsTransfer.getSrcAcc());
		custSourceAccount = custSrcAccount.get(0);
		
		SrcCurBalance = (int) custSourceAccount.getBalance();
		SrcNewBalance = (int) (SrcCurBalance - newFundsTransfer.getTransferAmount());
		custSourceAccount.setBalance(SrcNewBalance);
		custRepo.save(custSourceAccount);
		
		//Update Target Account
		
		custTgtAccount = this.custRepo.findByAcctNumber(newFundsTransfer.getTgtAcc());
		custTargetAccount = custTgtAccount.get(0);
		
		TgtCurBalance = (int) custTargetAccount.getBalance();
		TgtNewBalance = (int) (TgtCurBalance + newFundsTransfer.getTransferAmount());
		custTargetAccount.setBalance(TgtNewBalance);
		custRepo.save(custTargetAccount);
		
		
		
		//Update Source Account Transactions Repo
		AccountTransactions srcAccountTran = new AccountTransactions();
		srcAccountTran.setAccNumber(newFundsTransfer.getSrcAcc());
		srcAccountTran.setClosingBalance(SrcNewBalance);
		srcAccountTran.setTranAmount(newFundsTransfer.getTransferAmount());
		srcAccountTran.settransferDate(new Date());
		srcAccountTran.setTranDrCrFlg("DR");
		srcAccountTran.setOpeningBalance(SrcCurBalance);
		srcAccountTran.setTranStatus("SUCCESS");
		String accountTranKey = "REF-" + newFundsTransfer.getSrcAcc() + "-" + dateFormat.format(new Date());
		srcAccountTran.setTranID(accountTranKey);
		acctTransactions.add(srcAccountTran);
		
		
		//Update Target Account Transactions Repo
		AccountTransactions tgtAccountTran = new AccountTransactions();
		tgtAccountTran.setAccNumber(newFundsTransfer.getTgtAcc());
		tgtAccountTran.setClosingBalance(TgtNewBalance);
		tgtAccountTran.setTranAmount(newFundsTransfer.getTransferAmount());
		tgtAccountTran.settransferDate(new Date());
		tgtAccountTran.setTranDrCrFlg("CR");
		tgtAccountTran.setTranStatus("SUCCESS");
		tgtAccountTran.setOpeningBalance(TgtCurBalance);
		String accountTgtTranKey = "REF-" + newFundsTransfer.getTgtAcc() + "-" + dateFormat.format(new Date());
		tgtAccountTran.setTranID(accountTgtTranKey);
		acctTransactions.add(tgtAccountTran);
		acctrnRepo.saveAll(acctTransactions);
		
		// Update Funds Transfer Repo
		// this repo states src,tgt,amt,urn,status,time. 
		newFundsTransfer.setTransferStatus("SUCCESS");
		newFundsTransfer.settransferTime(new Date());
		newFundsTransfer.setTransferRefNo(transferRefKey);
		TransferFunds fundTransfer = this.fundTrasnferRepo.save(newFundsTransfer);	
		
		
		Statement srcStt = new Statement();
		Statement tgtStt = new Statement();
		
		srcStt.setAcct_number(newFundsTransfer.getSrcAcc());
		srcStt.setFrom_acct_number(newFundsTransfer.getTgtAcc());
		
		srcStt.setTranactionID("REF-" + newFundsTransfer.getSrcAcc() + "-" + dateFormat.format(new Date()));
		tgtStt.setTranactionID("REF-" + newFundsTransfer.getTgtAcc() + "-" + dateFormat.format(new Date()));
		
		
		tgtStt.setAcct_number(newFundsTransfer.getTgtAcc());
		tgtStt.setFrom_acct_number(newFundsTransfer.getSrcAcc());
		
		srcStt.setTransaction_date(newFundsTransfer.gettransferTime());
		tgtStt.setTransaction_date(newFundsTransfer.gettransferTime());
		
		srcStt.setStatus(newFundsTransfer.getTransferStatus());
		tgtStt.setStatus(newFundsTransfer.getTransferStatus());
		
		srcStt.setOpening_balance(custSourceAccount.getBalance() );
		srcStt.setClosing_balance(srcStt.getOpening_balance() - newFundsTransfer.getTransferAmount());
		
		tgtStt.setOpening_balance( custTargetAccount.getBalance());
		tgtStt.setClosing_balance(tgtStt.getOpening_balance() + newFundsTransfer.getTransferAmount());
		
		if(srcStt.getOpening_balance()< srcStt.getClosing_balance()) {
			srcStt.setDeposit(1);
			srcStt.setWithdrawal(0);			
		}
		else {
			srcStt.setDeposit(0);
			srcStt.setWithdrawal(1);
		}
		if(tgtStt.getOpening_balance()< tgtStt.getClosing_balance()) {
			tgtStt.setDeposit(1);
			tgtStt.setWithdrawal(0);			
		}
		else {
			tgtStt.setDeposit(0);
			tgtStt.setWithdrawal(1);
		}
		
		srcStt.setFirst_name(custSourceAccount.getFirstName());
		tgtStt.setFirst_name(custTargetAccount.getFirstName());
		srcStt.setLast_name(custSourceAccount.getLastName());
		tgtStt.setLast_name(custTargetAccount.getLastName());
		
		srcStt.setAddress_line1(custSourceAccount.getAddrLine1());
		srcStt.setAddress_line2(custSourceAccount.getAddrLine2());
		srcStt.setBranch_location(custSourceAccount.getBranchLocation());
		srcStt.setCity(custSourceAccount.getCity());
		srcStt.setPostal_code(custSourceAccount.getPostalCode());
		srcStt.setState(custSourceAccount.getState());
		srcStt.setMobile_number(custSourceAccount.getMobileNumber());
		srcStt.setEmail_id(custSourceAccount.getMobileNumber());
		srcStt.setCountry(custSourceAccount.getCountry());
		
		tgtStt.setAddress_line1(custTargetAccount.getAddrLine1());
		tgtStt.setAddress_line2(custTargetAccount.getAddrLine2());
		tgtStt.setBranch_location(custTargetAccount.getBranchLocation());
		tgtStt.setCity(custTargetAccount.getCity());
		tgtStt.setPostal_code(custTargetAccount.getPostalCode());
		tgtStt.setState(custTargetAccount.getState());
		tgtStt.setMobile_number(custTargetAccount.getMobileNumber());
		tgtStt.setEmail_id(custTargetAccount.getMobileNumber());
		tgtStt.setCountry(custTargetAccount.getCountry());
		
		
		
		//srcStt.setTransUrn(dateFormat.format(new Date());
		//tgtStt.setTransUrn(dateFormat.format(new Date());
		
		sttRepo.save(srcStt);
		sttRepo.save(tgtStt);
		
		
		return fundTransfer;
	}
	
	@Override
	public List<TransferFunds> getAllTransferFunds() {
		
		return this.fundTrasnferRepo.findAll();
		
	}
	
}
