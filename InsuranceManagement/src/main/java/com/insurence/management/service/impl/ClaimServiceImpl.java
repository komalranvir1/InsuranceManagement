package com.insurence.management.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurence.management.entites.Claim;
import com.insurence.management.entites.InsurancePolicy;
import com.insurence.management.model.ApiResponse;
import com.insurence.management.repo.ClaimRepository;
import com.insurence.management.repo.InsurencePolicyRepository;
import com.insurence.management.service.ClaimService;

@Service
@Transactional
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private InsurencePolicyRepository policyRepository;

	@Override
	public ApiResponse getAllClaim() {
		// TODO Auto-generated method stub
		return new ApiResponse(HttpStatus.OK, "Claims found successfully....", claimRepository.findAll());
	}

	@Override
	public ApiResponse getClaimsById(Long id) {
		// TODO Auto-generated method stub
		Optional<Claim> claim = claimRepository.findById(id);
		if (claim.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "Claims result of this id not found");
		}
		return new ApiResponse(HttpStatus.OK, " Claims result found", claim);

	}

	@Override
	public ApiResponse updateClaimsById(Long id, Claim dto) {
		// TODO Auto-generated method stub
		Optional<Claim> claim = claimRepository.findById(id);
		if (claim.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, " above id Not Found");
		}
		claim.get().setClaimNo(dto.getClaimNo());
		claim.get().setClaimStatus(dto.getClaimStatus());
		claim.get().setClaimDate(dto.getClaimDate());
		claim.get().setDiscription(dto.getDiscription());

		return new ApiResponse(HttpStatus.OK, "Updated Successfully", claim);
	}

	@Override
	public ApiResponse deleteClaimById(Long id) {
		// TODO Auto-generated method stub
		
		
		Optional<Claim> claim = claimRepository.findById(id);
		if (claim.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "Above Id is Not Found");
		}
		claimRepository.deleteById(id);
		return new ApiResponse(HttpStatus.OK, "id Deleted Successfully");
	}

	@Override
	public ApiResponse addClaim(Claim claim) {
		// TODO Auto-generated method stub
		return new ApiResponse(HttpStatus.OK, "Claims added successfully...", claimRepository.save(claim));

	}

	@Override
	public ApiResponse assoshiateClaimToInsurence(Long claim_id, Long policy_id) {
		// TODO Auto-generated method stub

		Optional<Claim> claim = claimRepository.findById(claim_id);
		if (claim.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "Above claim_id not Found");
		}
		Optional<InsurancePolicy> policy = policyRepository.findById(policy_id);
		if (policy.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "Above policy_id not Found");
		}
		claim.get().setInsurancePolicy(policy.get());
		claimRepository.save(claim.get());
		return new ApiResponse(HttpStatus.OK, "Asosiate Claim With Policy", claim);
	}

}
