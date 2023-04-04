package com.insurence.management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurence.management.entites.Client;

@Repository
public interface Clientrepository extends JpaRepository<Client, Long>{

//	public boolean existsByEmail(String email);

	public Optional<Client> findByEmail(String email);



}
