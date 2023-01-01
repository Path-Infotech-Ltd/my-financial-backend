package com.exam.service.impl;

import com.exam.model.BankMaster;
import com.exam.model.PolicyPremiumMode;
import com.exam.repository.BankMasterRepository;
import com.exam.repository.PolicyPremiumModeRepository;
import com.exam.service.BankMasterService;
import com.exam.service.PolicyPremiumModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PolicyPremiumModeServiceImpl implements PolicyPremiumModeService {

	@Autowired
	private PolicyPremiumModeRepository policyPremiumModeRepository;

	@Override
	public List<PolicyPremiumMode> getAllPremiumModes() {
//		return new ArrayList<>(this.bankMasterRepository.findAllByOrderByBankNameAsc());
		return new ArrayList<>(policyPremiumModeRepository.findAll(Sort.by(Sort.Direction.ASC, "premiumMode")));
	}

	@Override
	public void deletePremiumMode(Long premiumModeId) {
		PolicyPremiumMode policyPremiumMode = new PolicyPremiumMode();
		policyPremiumMode.setId(premiumModeId);
		this.policyPremiumModeRepository.delete(policyPremiumMode);

	}

	@Override
	public PolicyPremiumMode getPremiumModeById(Long bankId) {
		PolicyPremiumMode policyPremiumMode = this.policyPremiumModeRepository.findById(bankId).get();
		return policyPremiumMode;
	}

	@Override
	public List<PolicyPremiumMode> sortByPremiumMode(String sortDir) {
		String sortBy = "premiumMode";
//	     String sortDir = "DESC";

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		List<PolicyPremiumMode> policyPremiumMode = this.policyPremiumModeRepository.findAll(sort);
		return policyPremiumMode;
	}

}
