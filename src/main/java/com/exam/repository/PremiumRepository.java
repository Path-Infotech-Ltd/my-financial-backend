package com.exam.repository;

import com.exam.model.Emi;
import com.exam.model.LifeInsurance;
import com.exam.model.Loan;
import com.exam.model.Premiums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PremiumRepository extends JpaRepository<Premiums, Long> {

	
	List<Premiums> findBylifeInsurance(LifeInsurance lifeInsurance);

	@Query("select p from Premiums p inner join fetch p.lifeInsurance where p.id=:id")
	Premiums findAllById(Long id);

}
