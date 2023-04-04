package com.insurence.management.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurence.management.entites.Claim;
import com.insurence.management.entites.Client;
import com.insurence.management.entites.InsurancePolicy;
import com.insurence.management.model.ApiResponse;
import com.insurence.management.repo.ClaimRepository;
import com.insurence.management.repo.Clientrepository;
import com.insurence.management.repo.InsurencePolicyRepository;
import com.insurence.management.service.InsurencePolicyService;

@Service
@Transactional
public class InsurencePolicyServiceImpl implements InsurencePolicyService {

	@Autowired
	private InsurencePolicyRepository insurencePolicyRepo;
	@Autowired
	private Clientrepository clientRepository;
	
	@Autowired
	private ClaimRepository claimRepository;

	@Override
	public ApiResponse getAllInsurencePolicies() {
		// TODO Auto-generated method stub
		return new ApiResponse(HttpStatus.OK, "All Insurence policy Result", insurencePolicyRepo.findAll());

	}

	@Override
	public ApiResponse getByInsurencePoliciesById(Long id) {
		// TODO Auto-generated method stub
		Optional<InsurancePolicy> insurencePolicy = insurencePolicyRepo.findById(id);
		if (insurencePolicy.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "Insurence policy Result not found for above id: " + id);
		}
		return new ApiResponse(HttpStatus.OK, "Insurence policy Result", insurencePolicy);
	}

	@Override
	public ApiResponse AddInsurencePolicy(InsurancePolicy insurancePolicy) {
		// TODO Auto-generated method stub
		
		return new ApiResponse(HttpStatus.OK, "InsurancePolicy added Successfully ... ",
				insurencePolicyRepo.save(insurancePolicy));
	}

	@Override
	public ApiResponse updateInsurencePolicyById(Long id, InsurancePolicy dto) {
		// TODO Auto-generated method stub
		Optional<InsurancePolicy> insurancePolicy = insurencePolicyRepo.findById(id);
		if (insurancePolicy.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "client not found for above id: " + id);
		}
		insurancePolicy.get().setPolicyNo(dto.getPolicyNo());
		insurancePolicy.get().setPolicyType(dto.getPolicyType());
		insurancePolicy.get().setCoverageAmt(dto.getCoverageAmt());
		insurancePolicy.get().setStartDate(dto.getStartDate());
		insurancePolicy.get().setEndDate(dto.getEndDate());
		insurancePolicy.get().setPremium(dto.getPremium());

		return new ApiResponse(HttpStatus.OK, "Result Updated Successfully", insurancePolicy);
	}

	@Override
	public ApiResponse deleteInsurencePolicyById(Long id) {
		
		Optional<Claim> claim = claimRepository.findByInsorencePoliciayId(id);
		
		if(claim.isPresent()) {
			claim.get().setInsurancePolicy(null);
			claimRepository.save(claim.get());
		}
		
		Optional<InsurancePolicy> insurancePolicy = insurencePolicyRepo.findById(id);
		if (insurancePolicy.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "insurencePolicy Of above id is not found");
		}
		insurencePolicyRepo.deleteById(id);
		return new ApiResponse(HttpStatus.OK, "Above Id Deleted  Successfully...");
	}

	@Override
	public ApiResponse assoshiatePolicyToClient(Long client_id, Long policy_id) {
		// TODO Auto-generated method stub
		Optional<InsurancePolicy> policy = insurencePolicyRepo.findById(policy_id);
		if (policy.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "policy  not found for above id: " + policy_id);
		}
		Optional<Client> client = clientRepository.findById(client_id);
		if (client.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "client not found for above id: " + client_id);
		}
		policy.get().setClient(client.get());

		return new ApiResponse(HttpStatus.OK, "Policy is assoshiated with client ");	}

}
