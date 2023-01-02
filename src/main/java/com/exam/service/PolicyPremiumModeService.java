package com.exam.service;

import com.exam.model.BankMaster;
import com.exam.model.PolicyPremiumMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PolicyPremiumModeService {

	public List<PolicyPremiumMode> getAllPremiumModes();

	public void deletePremiumMode(Long premiumModeId);

	public PolicyPremiumMode getPremiumModeById(Long premiumModeId);

	public List<PolicyPremiumMode> sortByPremiumMode(String direction);

}
