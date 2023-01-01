package com.exam.service;

import com.exam.dto.LifeInsuranceRequest;
import com.exam.dto.LifeInsuranceResponse;
import com.exam.dto.LoanResponse;
import com.exam.model.LifeInsurance;
import com.exam.model.Loan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface LifeInsuranceService {

    public LifeInsuranceResponse addPolicy(LifeInsuranceRequest lifeInsuranceRequest)  throws UnsupportedOperationException, URISyntaxException, IOException;

    public List<LifeInsurance> getAllPolicies();

    void deletePolicy(Long policyId);

    public List<LifeInsurance> findAllLifeInsurancePoliciesProcedure(String policyNo, boolean policyStatus, String bankName);

    public List<LifeInsurance> getAllActivePolicies();
}
