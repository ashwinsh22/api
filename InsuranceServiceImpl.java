package com.scb.personalBanking.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.personalBanking.entity.Insurance;
import com.scb.personalBanking.repository.InsuranceRepository;
import com.scb.personalBanking.service.InsuranceService;


@Service
public class InsuranceServiceImpl implements InsuranceService {
	
	@Autowired
	private InsuranceRepository insRepo;

	@Override
	public Insurance createInsurance(Insurance newInsurance) {
		
		Insurance insurance = this.insRepo.save(newInsurance);
		
		return insurance;
	}


}
