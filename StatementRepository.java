package com.scb.personalBanking.repository;

import org.springframework.stereotype.Repository;
import com.scb.personalBanking.entity.Statement;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface StatementRepository extends JpaRepository<Statement,Long> {
	
	
	@Query(value = "SELECT * FROM STATEMENT WHERE TRANS_URN = ?1", nativeQuery = true)
	Statement findByURNNative(long transUrn);
}

