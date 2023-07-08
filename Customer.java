package com.scb.personalBanking.entity;

import java.util.Date;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Customer {
	
	Random rand = new Random();
	int acctNumber = rand.nextInt(999999);
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date account_opening_date;
	
	@PrePersist
	private void onCreate() { 
	account_opening_date = new Date();
	}
	
	@Id
	private long customer_id;
	private String first_name;
	private String last_name;
	private String account_type;
	private String branch_location;
	private String address_line1;
	private String address_line2;
	private String city;
	private String postal_code;
	private String state;
	private String country;
    private String mobile_number;
	private String email_id;
	private String nominee_name;
	private String nominee_relationship;
	private long balance;
	private String password;
	private String role;
	
	

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public int getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(int acctNumber) {
		this.acctNumber = acctNumber;
	}

	public Date getAccount_opening_date() {
		return account_opening_date;
	}

	public void setAccount_opening_date(Date account_opening_date) {
		this.account_opening_date = account_opening_date;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
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

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getBranch_location() {
		return branch_location;
	}

	public void setBranch_location(String branch_location) {
		this.branch_location = branch_location;
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

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
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

	public String getNominee_name() {
		return nominee_name;
	}

	public void setNominee_name(String nominee_name) {
		this.nominee_name = nominee_name;
	}

	public String getNominee_relationship() {
		return nominee_relationship;
	}

	public void setNominee_relationship(String nominee_relationship) {
		this.nominee_relationship = nominee_relationship;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getId() {
		return customer_id;
	}

	public void setId(long id) {
		this.customer_id = id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public String getAccountType() {
		return account_type;
	}

	public void setAccountType(String account_type) {
		this.account_type = account_type;
	}
		
	public String getBranchLocation() {
		return branch_location;
	}

	public void setBranchLocation(String branch_location) {
		this.branch_location = branch_location;
	}

	public String getAddrLine1() {
		return address_line1;
	}

	public void setAddrLine1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddrLine2() {
		return address_line2;
	}

	public void setAddrLine2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postal_code;
	}

	public void setPostalCode(String postal_code) {
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
	
	public String getMobileNumber() {
		return mobile_number;
	}

	public void setMobileNumber(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	public String getEmailId() {
		return email_id;
	}

	public void setEmailId(String email_id) {
		this.email_id = email_id;
	}
	
	public String getNomineeName() {
		return nominee_name;
	}

	public void setNomineeName(String nominee_name) {
		this.nominee_name = nominee_name;
	}
	
	public String getNomineeRelationship() {
		return nominee_relationship;
	}

	public void setNomineeRelationship(String nominee_relationship) {
		this.nominee_relationship = nominee_relationship;
	}
	

	public int getAccountNumber() {
		return acctNumber;
	}

	public void setAccountNumber(int acctNumber) {
		this.acctNumber = acctNumber;
	}
	
		
    public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	

    public Date getAccountOpeningDate() {
		return account_opening_date;
	}

	public void setAccountOpeningDate(Date account_opening_date) {
		this.account_opening_date = account_opening_date;
	}
	
}


	
