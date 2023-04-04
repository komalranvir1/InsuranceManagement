package com.insurence.management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insurence.management.entites.InsurancePolicy;

public interface InsurencePolicyRepository extends JpaRepository<InsurancePolicy, Long> {

	@Query(value = "SELECT * FROM insurance_policy where client_id= :id", nativeQuery = true)
	Optional<InsurancePolicy> findByClientId(Long id);



	
	
}
