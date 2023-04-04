package com.insurence.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurence.management.entites.Claim;
import com.insurence.management.model.ApiResponse;
import com.insurence.management.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimsController {

	@Autowired
	private ClaimService claimService;

	@GetMapping()
	public ApiResponse getAllClaim() {
		return claimService.getAllClaim();

	}

	@GetMapping("/{id}")
	public ApiResponse getClaimsById(@PathVariable Long id) {

		return claimService.getClaimsById(id);
	}

	@PostMapping()
	public ApiResponse addClaims(@RequestBody Claim claim) {

		return claimService.addClaim(claim);
	}

	@PutMapping("/{id}")
	public ApiResponse updateClaimsById(@PathVariable Long id, @RequestBody Claim dto) {

		return claimService.updateClaimsById(id, dto);
	}

	@DeleteMapping("/delete/{id}")
	public ApiResponse deleteClaimById(@PathVariable Long id) {

		return claimService.deleteClaimById(id);
	}
	
	@PutMapping("/{policy_id}/claim/{claim_id}")
	public ApiResponse assoshiateClaimToInsurence(@PathVariable Long claim_id, @PathVariable Long policy_id) {

		return claimService.assoshiateClaimToInsurence(claim_id,policy_id); 


	}
}
