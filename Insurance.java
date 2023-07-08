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
public class Insurance {
	
	Random rand = new Random();
	int acct_number = rand.nextInt(999999);
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date account_opening_date;
	
	@PrePersist
	private void onCreate() { 
	account_opening_date = new Date();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customer_id;
	private String customer_first_name;
	private String customer_last_name;
	private String customer_dob;
	private String policy_name;
	private String policy_type;
	private long sum_assured;
	private String premium_amount;
	private String period_of_insurance;
	private String insured_addr_line1;
	private String insured_addr_line2;
	private String insured_city;
    private String insured_country;
	private String insured_postal_code;
	private String insured_state;
	private String country_code;
	private String mobile_number;
	private String email_id;
    private String nominee_name1;
	private String nominee_relation1;
	private String nominee_share1;
	private String nominee_address1;
    private String nominee_name2;
	private String nominee_relation2;
	private String nominee_share2;
	private String nominee_address2;
		

	public long getId() {
		return customer_id;
	}

	public void setId(long id) {
		this.customer_id = id;
	}

	
	public void setAccountOpeningDate(Date account_opening_date) {
		this.account_opening_date = account_opening_date;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public int getAcct_number() {
		return acct_number;
	}

	public void setAcct_number(int acct_number) {
		this.acct_number = acct_number;
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

	public String getCustomer_first_name() {
		return customer_first_name;
	}

	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}

	public String getCustomer_last_name() {
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}

	public String getCustomer_dob() {
		return customer_dob;
	}

	public void setCustomer_dob(String customer_dob) {
		this.customer_dob = customer_dob;
	}

	public String getPolicy_name() {
		return policy_name;
	}

	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}

	public String getPolicy_type() {
		return policy_type;
	}

	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}

	public long getSum_assured() {
		return sum_assured;
	}

	public void setSum_assured(long sum_assured) {
		this.sum_assured = sum_assured;
	}

	public String getPremium_amount() {
		return premium_amount;
	}

	public void setPremium_amount(String premium_amount) {
		this.premium_amount = premium_amount;
	}

	public String getPeriod_of_insurance() {
		return period_of_insurance;
	}

	public void setPeriod_of_insurance(String period_of_insurance) {
		this.period_of_insurance = period_of_insurance;
	}

	public String getInsured_addr_line1() {
		return insured_addr_line1;
	}

	public void setInsured_addr_line1(String insured_addr_line1) {
		this.insured_addr_line1 = insured_addr_line1;
	}

	public String getInsured_addr_line2() {
		return insured_addr_line2;
	}

	public void setInsured_addr_line2(String insured_addr_line2) {
		this.insured_addr_line2 = insured_addr_line2;
	}

	public String getInsured_city() {
		return insured_city;
	}

	public void setInsured_city(String insured_city) {
		this.insured_city = insured_city;
	}

	public String getInsured_country() {
		return insured_country;
	}

	public void setInsured_country(String insured_country) {
		this.insured_country = insured_country;
	}

	public String getInsured_postal_code() {
		return insured_postal_code;
	}

	public void setInsured_postal_code(String insured_postal_code) {
		this.insured_postal_code = insured_postal_code;
	}

	public String getInsured_state() {
		return insured_state;
	}

	public void setInsured_state(String insured_state) {
		this.insured_state = insured_state;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
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

	public String getNominee_name1() {
		return nominee_name1;
	}

	public void setNominee_name1(String nominee_name1) {
		this.nominee_name1 = nominee_name1;
	}

	public String getNominee_relation1() {
		return nominee_relation1;
	}

	public void setNominee_relation1(String nominee_relation1) {
		this.nominee_relation1 = nominee_relation1;
	}

	public String getNominee_share1() {
		return nominee_share1;
	}

	public void setNominee_share1(String nominee_share1) {
		this.nominee_share1 = nominee_share1;
	}

	public String getNominee_address1() {
		return nominee_address1;
	}

	public void setNominee_address1(String nominee_address1) {
		this.nominee_address1 = nominee_address1;
	}

	public String getNominee_name2() {
		return nominee_name2;
	}

	public void setNominee_name2(String nominee_name2) {
		this.nominee_name2 = nominee_name2;
	}

	public String getNominee_relation2() {
		return nominee_relation2;
	}

	public void setNominee_relation2(String nominee_relation2) {
		this.nominee_relation2 = nominee_relation2;
	}

	public String getNominee_share2() {
		return nominee_share2;
	}

	public void setNominee_share2(String nominee_share2) {
		this.nominee_share2 = nominee_share2;
	}

	public String getNominee_address2() {
		return nominee_address2;
	}

	public void setNominee_address2(String nominee_address2) {
		this.nominee_address2 = nominee_address2;
	}

	
}


	

