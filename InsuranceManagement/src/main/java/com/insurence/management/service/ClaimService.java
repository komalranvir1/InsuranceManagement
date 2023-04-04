package com.insurence.management.service;

import org.springframework.stereotype.Service;

import com.insurence.management.entites.Claim;
import com.insurence.management.model.ApiResponse;

@Service
public interface ClaimService {

	ApiResponse getAllClaim();

	ApiResponse getClaimsById(Long id);

	ApiResponse updateClaimsById(Long id, Claim dto);

	ApiResponse deleteClaimById(Long id);

	ApiResponse addClaim(Claim claim);

	ApiResponse assoshiateClaimToInsurence(Long claim_id, Long policy_id);

}
