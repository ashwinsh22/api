package com.scb.personalBanking.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.print.attribute.standard.DateTimeAtCompleted;

@Entity
public class Statement {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private long transUrn;
	
	private String tranactionID;
	private long acct_number;
	private String first_name;
	private String last_name;
	private String address_line1;
	private String address_line2;
	private String branch_location;
	private String city;
	private String postal_code;
	private String state;
	private String country;
    private String mobile_number;
	private String email_id;
	private long opening_balance;
	private long closing_balance;
	private Date transaction_date; 
	private String description;
	private long deposit;
	private long withdrawal;
	private int BUSINESS_CODE;
	private long from_acct_number;
	private String status;
	
	public String getTranactionID() {
		return tranactionID;
	}
	public void setTranactionID(String tranactionID) {
		this.tranactionID = tranactionID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getAcct_number() {
		return acct_number;
	}
	public void setAcct_number(long acct_number) {
		this.acct_number = acct_number;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public long getTransUrn() {
		return transUrn;
	}
	public void setTransUrn(long transUrn) {
		this.transUrn = transUrn;
	}
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getBranch_location() {
		return branch_location;
	}
	public void setBranch_location(String branch_location) {
		this.branch_location = branch_location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public long getOpening_balance() {
		return opening_balance;
	}
	public void setOpening_balance(long opening_balance) {
		this.opening_balance = opening_balance;
	}
	public long getClosing_balance() {
		return closing_balance;
	}
	public void setClosing_balance(long closing_balance) {
		this.closing_balance = closing_balance;
	}
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getDeposit() {
		return deposit;
	}
	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}
	public long getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(long withdrawal) {
		this.withdrawal = withdrawal;
	}
	public int getBUSINESS_CODE() {
		return BUSINESS_CODE;
	}
	public void setBUSINESS_CODE(int bUSINESS_CODE) {
		BUSINESS_CODE = bUSINESS_CODE;
	}
	public long getFrom_acct_number() {
		return from_acct_number;
	}
	public void setFrom_acct_number(long from_acct_number) {
		this.from_acct_number = from_acct_number;
	}
	
	
		
}




