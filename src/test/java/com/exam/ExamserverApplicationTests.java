package com.exam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.constant.StatusConstant;
import com.exam.model.Loan;
import com.exam.repository.LoanRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ExamserverApplicationTests {

	@Autowired
	LoanRepository loanRepository;
	
	Long loanId = 0L;

//	@Test
//	@Order(1)
	public void testCreate() {
		Loan loan = new Loan();
		

		loan.setLoanId(5775L);
		loan.setLoanNo("123456789");
		loan.setLoanType("PERSONAL LOAN");
		loan.setDisbursalDate(LocalDate.of(2022, 07, 17));
		loan.setEmiAmount(new BigDecimal("12000.00"));
		loan.setEmiPaid(0L);
		loan.setEmiRemaining(36L);
		loan.setFirstEmiDate(LocalDate.of(2022, 02, 05));
		loan.setInterestPaid(new BigDecimal("0.0"));
		loan.setInterestType("FIXED");
		loan.setLastEmiDate(LocalDate.of(2025, 03, 05));
		loan.setLoanAmount(new BigDecimal("500000.00"));
		loan.setLogoName("axis_logo.png");

		loan.setBank("AXIS BANK");
		loan.setInterestRate(new BigDecimal("7.25"));
		loan.setLoanStatus(true);
		loan.setTotalEmi(36L);
		loan.setStatus(StatusConstant.STATUS_ACTIVE);
		loan.setCreatedBy("sunilkmr5775");
		loan.setCreatedDate(LocalDateTime.now());
		loan.setModifiedBy(null);
		loan.setModifiedDate(null);
		loanId = loanRepository.save(loan).getLoanId();

		assertNotNull(loanRepository.findById(loanId).get());
	}

	@Test
	@Order(2)
	public void testReadAll() {
		List list = loanRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testRead() {
		Loan loan = loanRepository.findById(1540L).get();
		Assertions.assertEquals(123456789L, Long.parseLong(loan.getLoanNo()));
	}

	@Test
	@Order(4)
	public void testUpdate() {
		Loan p = loanRepository.findById(1540L).get();
		p.setLoanAmount(new BigDecimal("600000.00"));
		loanRepository.save(p);
		Assertions.assertNotEquals(new Double(500000.00), loanRepository.findById(1540L).get().getLoanAmount());
	}

//	@Test
//	@Order(5)
//	public void testDelete() {
//		loanRepository.deleteById(1537L);
//		assertThat(loanRepository.existsById(1537L)).isFalse();
//	}
}
