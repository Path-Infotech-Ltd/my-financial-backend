package com.exam.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.dto.LoanRequest;
import com.exam.dto.LoanResponse;
import com.exam.model.Loan;
import com.exam.model.LoanTypes;

@Service
public interface LoanService {
	

	public LoanResponse addNewLoan(LoanRequest loanRequest) throws UnsupportedOperationException, URISyntaxException, IOException ;
	
	public Loan updateLoan(Loan loan);
	
	public List<Loan> getAllLoans();
	
	public List<Loan> getAllActiveLoans();
	
	public Loan getLoan(Long loanId) ;
	
	public void deleteLoan(Long loanId);

	public Set<Loan> getLoansByStatus(String loanStatus); 
	
	public List<Loan> findAllLoanStoredProcedure( String loanNo, String loanStatus, String bankName);

	public List<LoanTypes> getAllLoanTypes();

	public void deleteByLoanNo(String loanNo);
	
}
