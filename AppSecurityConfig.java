package com.scb.personalBanking.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String ADMIN = "admin";  
	private static final String CUSTOMER = "cust";  

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		auth.inMemoryAuthentication()
		.withUser("axess1").password("12345").authorities("admin")
		.and()
		.withUser("axess2").password("12345").authorities("read")
		.and()
		.withUser("axess3").password("12345").authorities("admin","read")
		.and()
		.withUser("ashwin").password("ashwin").authorities("admin")
		.and()
		.passwordEncoder(NoOpPasswordEncoder.getInstance());	
		*/
		
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		UserDetails user1 = User
				.withUsername("ashwin")
				.password(encoder.encode("6001"))
				//.password("6001")
				.authorities(ADMIN)
				.build();
		
		UserDetails user2 = User
				.withUsername("ramya")
				//.password("6002")
				.password(encoder.encode("6002"))
				.authorities(CUSTOMER)
				.build();
		UserDetails user3 = User
				.withUsername("vinod")
				//.password("6003")
				.password(encoder.encode("6003"))
				.authorities(ADMIN,CUSTOMER)
				.build();
		UserDetails user4 = User
				.withUsername("pirama")
				.password(encoder.encode("6004"))
				//.password("6004")
				.authorities(CUSTOMER)
				.build();
		UserDetails user5 = User
				.withUsername("pugazh")
				//.password("6005")
				.password(encoder.encode("6005"))
				.authorities(CUSTOMER)
				.build();
		
		
		userDetailsManager.createUser(user1);
		userDetailsManager.createUser(user2);
		userDetailsManager.createUser(user3);
		userDetailsManager.createUser(user4);
		userDetailsManager.createUser(user5);
		
		auth.userDetailsService(userDetailsManager);
		
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/insta-account-opening/**").hasAnyAuthority(ADMIN, CUSTOMER)
		.antMatchers("/apply-for-insurance/**").hasAuthority(ADMIN)
		.antMatchers("/transferFunds/**").hasAuthority(ADMIN)
		.antMatchers("/personal-banking/**").permitAll()		
		.antMatchers("/statement/**").hasAnyAuthority(ADMIN)
		.antMatchers("/home/**").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers("/swagger-ui/**").permitAll()
		.and()
		.httpBasic();
		
		
		http.csrf().disable();		
		// to display h2-console
		
		http.headers().frameOptions().disable();
}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		//return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
