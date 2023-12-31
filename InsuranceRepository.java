package com.scb.personalBanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scb.personalBanking.entity.Customer;
import com.scb.personalBanking.entity.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long>{

}
