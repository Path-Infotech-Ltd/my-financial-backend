package com.exam;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.exam.model.BankMaster;
import com.exam.repository.BankMasterRepository;

@SpringBootTest
public class PaginationAndSortingTest {

	@Autowired
	private BankMasterRepository bankMasterRepository;

	@Test
	void sorting() {

		String sortBy = "bankName";
		String sortDir = "DESC";

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		List<BankMaster> bank = bankMasterRepository.findAll(sort);

		bank.forEach((p) -> {
			System.out.println(p.getBankName());
		});
	}
}