package com.scb.personalBanking.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.scb.personalBanking.entity.Customer;
import com.scb.personalBanking.entity.Insurance;
import com.scb.personalBanking.repository.CustomerRepository;
import com.scb.personalBanking.repository.InsuranceRepository;

@Component
public class AppInitializer implements CommandLineRunner {
	
	@Autowired
	private InsuranceRepository insRepo;

	@Autowired
	private CustomerRepository custRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Application initiated");
		
		this.custRepo.saveAll(this.loadCustomerData());
		
	}
	
	private List<Customer> loadCustomerData() {
		
		Random rand = new Random();
		
		List<Customer> customers = new ArrayList<>();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Customer cust1 = new Customer();
		cust1.setCustomer_id(10002);
		cust1.setFirstName("Ramya");
		cust1.setLastName("Gajendran");
		cust1.setAccountType("Savings");
		cust1.setBranchLocation("Haddows Road");
		cust1.setAddrLine1("No 1 Sivan koil street");
		cust1.setAddrLine2("Kodambakkam");
		cust1.setCity("Chennai");
		cust1.setPostalCode("600024");
		cust1.setState("Tamilnadu");
		cust1.setCountry("India");
		cust1.setMobileNumber("8939299059");
		cust1.setEmailId("ramya.gajendran@gmail.com");
		cust1.setNomineeName("Radha");
		cust1.setNomineeRelationship("Sister");
		cust1.setBalance(15000);
		cust1.setAccountNumber(638745);		
		cust1.setPassword(encoder.encode("6002"));		
		cust1.setRole("cust");
		customers.add(cust1);
		//cust1.setPassword("6002");
		//cust1.setAccountNumber(rand.nextInt(999999));	
		
		Customer cust2 = new Customer();
		cust2.setCustomer_id(10006);
		cust2.setFirstName("Radha");
		cust2.setLastName("Gajendran");
		cust2.setAccountType("Savings");
		cust2.setBranchLocation("Haddows Road");
		cust2.setAddrLine1("No 1 Sivan koil street");
		cust2.setAddrLine2("Kodambakkam");
		cust2.setCity("Chennai");
		cust2.setPostalCode("600024");
		cust2.setState("Tamilnadu");
		cust2.setCountry("India");
		cust2.setMobileNumber("8939299059");
		cust2.setEmailId("Radha.gajendran@gmail.com");
		cust2.setNomineeName("Ramya");
		cust2.setNomineeRelationship("Sister");
		cust2.setBalance(10000);
		cust2.setAccountNumber(3984739);
		//cust2.setAccountNumber(rand.nextInt(999999));
		cust2.setRole("cust");
		cust2.setPassword(encoder.encode("6006"));
		//cust2.setPassword("6006");
		customers.add(cust2);
		
		Customer cust3 = new Customer();
		cust3.setFirstName("Ashwin");
		cust3.setCustomer_id(10001);
		cust3.setLastName("S H");
		cust3.setAccountType("Savings");
		cust3.setBranchLocation("Koramangala");
		cust3.setAddrLine1("Serenity Building");
		cust3.setAddrLine2("Ground Floor");
		cust3.setCity("Bangalore");
		cust3.setPostalCode("560095");
		cust3.setState("Karnataka");
		cust3.setCountry("India");
		cust3.setMobileNumber("8675645342");
		cust3.setEmailId("ashwinsh@gmail.com");
		cust3.setNomineeName("ASH");
		cust3.setNomineeRelationship("Bro");
		cust3.setBalance(10000);
		cust3.setAccountNumber(rand.nextInt(999999));	
		cust3.setRole("admin");
		cust3.setPassword(encoder.encode("6001"));
		//cust3.setPassword("6001");
		customers.add(cust3);
		
		Customer cust4 = new Customer();
		cust4.setFirstName("Vinod");
		cust4.setCustomer_id(10003);
		cust4.setLastName("V");
		cust4.setAccountType("Savings");
		cust4.setBranchLocation("Haddows Road");
		cust4.setAddrLine1("No 1 Sivan koil street");
		cust4.setAddrLine2("Kodambakkam");
		cust4.setCity("Chennai");
		cust4.setPostalCode("600024");
		cust4.setState("Tamilnadu");
		cust4.setCountry("India");
		cust4.setMobileNumber("9847539485");
		cust4.setEmailId("vinodv@gmail.com");
		cust4.setNomineeName("Binod");
		cust4.setNomineeRelationship("Bro");
		cust4.setBalance(10000);
		cust4.setAccountNumber(rand.nextInt(999999));	
		cust4.setRole("admin");
		cust4.setPassword(encoder.encode("6003"));
		//cust4.setPassword("6003");
		customers.add(cust4);
		
		Customer cust5 = new Customer();
		cust5.setFirstName("Pirama");
		cust5.setCustomer_id(10004);
		cust5.setLastName("U");
		cust5.setAccountType("Savings");
		cust5.setBranchLocation("Haddows Road");
		cust5.setAddrLine1("No 1 Sivan koil street");
		cust5.setAddrLine2("Kodambakkam");
		cust5.setCity("Chennai");
		cust5.setPostalCode("600024");
		cust5.setState("Tamilnadu");
		cust5.setCountry("India");
		cust5.setMobileNumber("9844747553");
		cust5.setEmailId("piramau@gmail.com");
		cust5.setNomineeName("Rama");
		cust2.setNomineeRelationship("Bro");
		cust5.setBalance(10000);
		cust5.setAccountNumber(rand.nextInt(999999));	
		cust5.setRole("admin");
		cust5.setPassword(encoder.encode("6004"));
		//cust5.setPassword("6004");
		customers.add(cust5);
		
		Customer cust6 = new Customer();
		cust6.setFirstName("Pugazh");
		cust6.setCustomer_id(10005);
		cust6.setLastName("P");
		cust6.setAccountType("Savings");
		cust6.setBranchLocation("Haddows Road");
		cust6.setAddrLine1("No 1 Sivan koil street");
		cust6.setAddrLine2("Kodambakkam");
		cust6.setCity("Chennai");
		cust6.setPostalCode("600024");
		cust6.setState("Tamilnadu");
		cust6.setCountry("India");
		cust6.setMobileNumber("9844747553");
		cust6.setEmailId("pugazh@gmail.com");
		cust6.setNomineeName("Rama");
		cust6.setNomineeRelationship("Bro");
		cust6.setBalance(10000);
		cust6.setAccountNumber(rand.nextInt(999999));	
		cust6.setRole("admin");
		cust6.setPassword(encoder.encode("6005"));
		//cust6.setPassword("6005");
		customers.add(cust6);
		
		
		return customers;
		
	}
	
	private List<Insurance> loadInsuranceData() {
		
		List<Insurance> insurances = new ArrayList<>();
		
		Insurance ins1 = new Insurance();
		
		//ins1.setCustomer_id("1431384");
		ins1.setCustomer_first_name("Piramanayagam");
		ins1.setCustomer_last_name("U");
		ins1.setCustomer_dob("20/01/1999");
		ins1.setPolicy_name("Jeevan Anand (Plan-149)"); 
		ins1.setPolicy_type("Life Insurance"); 
		ins1.setSum_assured(200000); 
		ins1.setPremium_amount("12000"); 
		ins1.setPeriod_of_insurance("20 Years");
		ins1.setInsured_addr_line1("Address 1");
		ins1.setInsured_addr_line2("Address 2");
		ins1.setInsured_city("City");
		ins1.setInsured_country("Country");
		ins1.setInsured_postal_code("654321");
		ins1.setInsured_state("State");
		ins1.setCountry_code("91");
		ins1.setMobile_number("9876543210");
		ins1.setEmail_id("Piramanayagam.U@sc.com");
		ins1.setNominee_name1("ABCD");
		ins1.setNominee_relation1("Mother");
		ins1.setNominee_share1("50%");
		ins1.setNominee_address1("Address 1, Address 2, City, State, Country, 654321, State, 9976543278");
		ins1.setNominee_name2("FGHJK");
		ins1.setNominee_relation2("Father");
		ins1.setNominee_share2("50%");
		ins1.setNominee_address2("Address 1, Address 2, City, State, Country, 654321, State, 9976567278");

		insurances.add(ins1);
		
		return insurances;
		
	}
	
	

}
