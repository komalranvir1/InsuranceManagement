package com.insurence.management.service;

import com.insurence.management.entites.InsurancePolicy;
import com.insurence.management.model.ApiResponse;

public interface InsurencePolicyService {

	ApiResponse getAllInsurencePolicies();

	ApiResponse getByInsurencePoliciesById(Long id);

	ApiResponse AddInsurencePolicy(InsurancePolicy insurancePolicy);

	ApiResponse updateInsurencePolicyById(Long id, InsurancePolicy dto);

	ApiResponse deleteInsurencePolicyById(Long id);

	ApiResponse assoshiatePolicyToClient(Long client_id, Long policy_id);

}
