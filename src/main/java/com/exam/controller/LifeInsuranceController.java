package com.exam.controller;

import com.exam.dto.LifeInsuranceRequest;
import com.exam.dto.LifeInsuranceResponse;
import com.exam.dto.LoanResponse;
import com.exam.model.LifeInsurance;
import com.exam.service.LifeInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Component
@CrossOrigin("*")
@RequestMapping("/life-insurances")
public class LifeInsuranceController {

	@Autowired
	private LifeInsuranceService lifeInsuranceService;

//	 test api
	@GetMapping("/testMsg")
	public String testApi() {
		return "This is a LifeInsurance Testing API";

	}

	@PostMapping("/")
	public LifeInsuranceResponse addPolicy(@Validated @RequestBody LifeInsuranceRequest lifeInsuranceRequest)
			throws UnsupportedOperationException, URISyntaxException, IOException {

		return lifeInsuranceService.addPolicy(lifeInsuranceRequest);

	}

////	 UPDATE LOAN
//	@PutMapping("/")
//	public ResponseEntity<Loan> updateLoan(@RequestBody Loan loan) {
//		loan.setModifiedDate(LocalDateTime.now());
//		Loan loan2 = this.loanService.updateLoan(loan);
//		return ResponseEntity.ok(loan2);
//
//	}
//
//	 GET ALL POLICIES
	@GetMapping("/")
	public List<LifeInsurance> getAllPolicies() {
		return new ArrayList<>(this.lifeInsuranceService.getAllPolicies());
	}

	//	 DELETE POLICY BY ID
	@DeleteMapping("/{policyId}")
	public void deletePolicy(@PathVariable Long policyId) {
		this.lifeInsuranceService.deletePolicy(policyId);
	}
//
//	 GET ALL ACTIVE POLICIES
	@GetMapping("/active")
	public List<LifeInsurance> getAllActivePolicies() {
		return new ArrayList<>(this.lifeInsuranceService.getAllActivePolicies());
	}
//
////	 GET LOANS BY STATUS
//	@GetMapping("/status/{loanStatus}")
//	public Set<Loan> getLoansByStatus(@PathVariable String loanStatus) {
//		return new HashSet<>(this.loanService.getLoansByStatus(loanStatus));
//	}
//
//	 FILTER LIFE INSURANCE POLICY
	@GetMapping("/filter-life-insurance-policy")
	public List<LifeInsurance> getPolicyRecordsByFiter(
			@RequestParam(value = "policyNo", required = false) String policyNo,
			@RequestParam(value = "policyStatus", required = false) String policyStatus,
			@RequestParam(value = "bankName", required = false) String bankName) {

		if(policyNo=="" || policyNo.equals("") || policyNo.equals("null")) {
			policyNo=null;
		}
		if(policyStatus=="" || policyStatus.equals("") || policyStatus.equals("null")) {
			policyStatus=null;
		}
		if(bankName=="" || bankName.equals("") || bankName.equals("null")) {
			bankName=null;
		}
		return new ArrayList<>(this.lifeInsuranceService.findAllLifeInsurancePoliciesProcedure(policyNo, policyStatus, bankName));

	}
//

//
////	 DELETE LOAN BY LOAN NO
//	/*
//	 * @DeleteMapping("/{loanNo}") public void deleteLoan(@PathVariable String
//	 * loanNo) { this.loanService.deleteByLoanNo(loanNo); }
//	 */
//
////	 GET LOAN BY ID
//	@GetMapping("/{loanId}")
//	public Loan getLoan(@PathVariable Long loanId) {
//		return this.loanService.getLoan(loanId);
//
//	}
//
////	 GET ALL LOAN TYPES
//	@GetMapping("/loanTypes")
//	public List<LoanTypes> getAllLoanTypes() {
//		return this.loanService.getAllLoanTypes();
//
//	}

}
