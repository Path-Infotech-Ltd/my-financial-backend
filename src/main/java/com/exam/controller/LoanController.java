package com.exam.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.LoanRequest;
import com.exam.dto.LoanResponse;
import com.exam.model.Loan;
import com.exam.service.LoanService;

@RestController
@Component
@CrossOrigin("*")
@RequestMapping("/loans")
public class LoanController {

	@Autowired
	private LoanService loanService;

//	 ADD LOAN
	@GetMapping("/testMsg")
	public String testApi() {
		return "This is a Testing API";

	}
	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	@ResponseBody
	@PostMapping("/")
	public LoanResponse addNewLoan(@Validated @RequestBody LoanRequest loanRequest) 
			throws UnsupportedOperationException, URISyntaxException, IOException {

		return loanService.addNewLoan(loanRequest);
		

	}

//	 UPDATE LOAN
	@PutMapping("/")
	public ResponseEntity<Loan> updateLoan(@RequestBody Loan loan) {
		loan.setModifiedDate(LocalDateTime.now());
		Loan loan2 = this.loanService.updateLoan(loan);
		return ResponseEntity.ok(loan2);

	}

//	 GET ALL LOANS
	@GetMapping("/")
	public Set<Loan> getAllLoans() {
		return new HashSet<>(this.loanService.getAllLoans());
	}
	
//	 GET ALL LOANS
	@GetMapping("/active")
	public Set<Loan> getAllActiveLoans() {
		return new HashSet<>(this.loanService.getAllActiveLoans());
	}

//	 GET LOAN BY ID
	@GetMapping("/{loanId}")
	public Loan getLoan(@PathVariable Long loanId) {
		return this.loanService.getLoan(loanId);

	}

//	 DELETE LOAN BY ID
	@DeleteMapping("/{loanId}")
	public void deleteCategory(@PathVariable Long loanId) {
		this.loanService.deleteLoan(loanId);

	}

}
