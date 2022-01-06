package com.exam.repository;

import java.util.LinkedHashSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

	Loan findByLoanNo(String loanNo);

	LinkedHashSet<Loan> findByStatus(String statusActive);

}
