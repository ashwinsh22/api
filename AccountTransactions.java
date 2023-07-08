package com.scb.personalBanking.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AccountTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int accountNumber;
	private String transactionID;
	private int transactionAmount;
	private String CreditDebitFlag;
	private String transactionStatus;
	private String transactionDescription;
	private int closingBalance;
	private int openingBalance;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date transactionDate;
	
	public int getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(int closingBalance) {
		this.closingBalance = closingBalance;
	}
	
	public int getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(int openingBalance) {
		this.openingBalance = openingBalance;
	}
	
	public String getTranDesc() {
		return transactionDescription;
	}

	public void setTranDesc(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	
	public String getTranStatus() {
		return transactionStatus;
	}

	public void setTranStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	
	public String getTranDrCrFlg() {
		return CreditDebitFlag;
	}

	public void setTranDrCrFlg(String CreditDebitFlag) {
		this.CreditDebitFlag = CreditDebitFlag;
	}
	
	public int getTranAmount() {
		return transactionAmount;
	}

	public void setTranAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	public String getTranID() {
		return transactionID;
	}

	public void setTranID(String transactionID) {
		this.transactionID = transactionID;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getAccNumber() {
		return accountNumber;
	}

	public void setAccNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@PrePersist
    private void onCreate() { 
		transactionDate = new Date();
    }
    
	public Date gettransferDate () {
          return transactionDate;
    }

    public void settransferDate (Date transactionDate) {
          this. transactionDate = transactionDate;
    }

	
		
}
