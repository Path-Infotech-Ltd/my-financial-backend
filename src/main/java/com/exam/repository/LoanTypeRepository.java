package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.LoanTypes;

@Repository
public interface LoanTypeRepository extends JpaRepository<LoanTypes, Long> {


}
