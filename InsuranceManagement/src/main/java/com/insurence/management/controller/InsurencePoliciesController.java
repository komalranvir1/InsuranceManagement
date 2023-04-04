package com.insurence.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurence.management.entites.InsurancePolicy;
import com.insurence.management.model.ApiResponse;
import com.insurence.management.service.InsurencePolicyService;

@RestController
@RequestMapping("/api/policies")
@CrossOrigin("*")
public class InsurencePoliciesController {
	
	@Autowired
	private InsurencePolicyService policyService;

	@GetMapping()
	public ApiResponse getAllInsurencePolicies() {
	return policyService.getAllInsurencePolicies(); 
	}

	@GetMapping("/{id}")
	public ApiResponse getByInsurencePoliciesById(@PathVariable Long id) {
		
		return policyService.getByInsurencePoliciesById(id); 

	}

	@PostMapping()
	public ApiResponse AddInsurencePolicy(@RequestBody InsurancePolicy insurancePolicy) {
	
		return policyService.AddInsurencePolicy(insurancePolicy); 

	}

	@PutMapping("/{id}")
	public ApiResponse updateInsurencePolicyById(@PathVariable Long id, @RequestBody InsurancePolicy dto) {
		
		return policyService.updateInsurencePolicyById(id,dto); 

	}

	@DeleteMapping("/delete/{id}")
	public ApiResponse deleteInsurencePolicyById(@PathVariable Long id) {
		
		return policyService.deleteInsurencePolicyById(id); 

	}

	@PutMapping("/{policy_id}/client/{client_id}")
	public ApiResponse assoshiatePolicyToClient(@PathVariable Long client_id, @PathVariable Long policy_id) {

		return policyService.assoshiatePolicyToClient(client_id,policy_id); 


	}

}
