package com.exam.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.model.Emi;
import com.exam.model.Loan;

@Service
public interface EmiService {
	
	
	public Emi addEmi(Emi emi);
	
	public Emi updateEmi(Emi emi);
	
	public Set<Emi> getEmis();
	
	public Emi getEmi(Long emiId);
	
	public void deleteEmi(Long emiId);
	
	public List<Emi> getEmiOfLoan(Loan loan);
	
}
