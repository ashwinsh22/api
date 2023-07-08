package com.scb.personalBanking.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class TransferFunds {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int sourceAccount;
	private int targetAccount;
	private int transferAmount;
	private String transferStatus;
	private String transferRefNo;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date transferTime;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getSrcAcc() {
		return sourceAccount;
	}

	public void setSrcAcc(int sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	
	public int getTgtAcc() {
		return targetAccount;
	}
	
	public void setTgtAcc (int targetAccount) {
		this.targetAccount = targetAccount;
	}
	
	public int getTransferAmount () {
		return transferAmount;
	}
	
	public void setTransferAmount (int transferAmount) {
		this.transferAmount = transferAmount;
	}
	
	@PrePersist
    private void onCreate() { 
    transferTime = new Date();
    }
    
	public Date gettransferTime () {
          return transferTime;
    }

    public void settransferTime (Date transferTime) {
          this. transferTime = transferTime;
    }
	
	public void setTransferStatus (String transferStatus) {
		this.transferStatus = transferStatus;
	}
	
	public String getTransferStatus () {
		return transferStatus;
	}
	
	public void setTransferRefNo (String transferRefNo) {
		this.transferRefNo = transferRefNo;
	}
	
	public String getTransferRefNo () {
		return transferRefNo;
	}
}
