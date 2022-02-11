package com.exam.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.dto.LoanRequest;
import com.exam.dto.LoanResponse;
import com.exam.model.Loan;

@Service
public interface LoanService {
	

	public LoanResponse addNewLoan(LoanRequest loanRequest) throws UnsupportedOperationException, URISyntaxException, IOException ;
	
	public Loan updateLoan(Loan loan);
	
	public Set<Loan> getAllLoans();
	
	public Set<Loan> getAllActiveLoans();
	
	public Loan getLoan(Long loanId) ;
	
	public void deleteLoan(Long loanId);
}
