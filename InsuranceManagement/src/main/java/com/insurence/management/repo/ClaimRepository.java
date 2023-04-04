package com.insurence.management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insurence.management.entites.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

	@Query(value = "SELECT * FROM claim where insurance_policy_id= :id", nativeQuery = true)
	Optional<Claim> findByInsorencePoliciayId(Long id);

}
