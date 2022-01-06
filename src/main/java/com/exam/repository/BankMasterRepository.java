package com.exam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.BankMaster;

@Repository
public interface BankMasterRepository extends JpaRepository<BankMaster, Long> {

	public Set<BankMaster> findAllByOrderByBankNameAsc();


}
