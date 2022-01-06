package com.exam.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.BankMaster;
import com.exam.model.Category;
import com.exam.model.Emi;
import com.exam.repository.BankMasterRepository;
import com.exam.service.BankMasterService;

@Service
public class BankMasterServiceImpl implements BankMasterService {

	
	@Autowired
	private BankMasterRepository bankMasterRepository;
	
	
	

	@Override
	public Set<BankMaster> getAllBanks() {
		return new LinkedHashSet<>(this.bankMasterRepository.findAllByOrderByBankNameAsc());
	}

	@Override
	public void deleteBank(Long bankId) {
		BankMaster bankMaster = new BankMaster();
		bankMaster.setId(bankId);
		this.bankMasterRepository.delete(bankMaster);
		
	}

	@Override
	public BankMaster getBank(Long bankId) {
		BankMaster bank = this.bankMasterRepository.findById(bankId).get();
			return bank;
	}
	
	
}
