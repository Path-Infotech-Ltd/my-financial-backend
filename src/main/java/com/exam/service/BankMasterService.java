package com.exam.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.model.BankMaster;
import com.exam.model.Emi;

@Service
public interface BankMasterService {

	public Set<BankMaster> getAllBanks();

	public void deleteBank(Long bankId);

	public BankMaster getBank(Long bankId);

}
