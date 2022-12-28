package com.exam.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.model.BankMaster;

@Service
public interface BankMasterService {

	public List<BankMaster> getAllBanks();

	public void deleteBank(Long bankId);

	public BankMaster getBank(Long bankId);

	public List<BankMaster> sortByBankName(String direction);

}
