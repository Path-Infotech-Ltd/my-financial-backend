package com.exam.service;

import com.exam.model.Emi;
import com.exam.model.LifeInsurance;
import com.exam.model.Loan;
import com.exam.model.Premiums;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface PremiumService {
	
	
	public Premiums addPremium(Premiums premium);
	
	public Premiums updatePremium(Premiums premium);
	
	public Set<Premiums> getPremiums();
	
	public Premiums getPremium(Long premiumId);
	
	public void deletePremium(Long premiumId);
	
	public List<Premiums> getPremiumOfLifeInsurance(LifeInsurance lifeInsurance);
	
}
