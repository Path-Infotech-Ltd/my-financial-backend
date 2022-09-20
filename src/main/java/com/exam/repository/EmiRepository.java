package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exam.model.Emi;
import com.exam.model.Loan;

@Repository
public interface EmiRepository extends JpaRepository<Emi, Long> {

	
	List<Emi> findByLoan(Loan loan);

	@Query("select e from Emi e inner join fetch e.loan where e.eId=:id")
	Emi findAllByEid(Long id);

}
