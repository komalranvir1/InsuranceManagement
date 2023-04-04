package com.insurence.management.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurence.management.entites.Client;
import com.insurence.management.entites.InsurancePolicy;
import com.insurence.management.model.ApiResponse;
import com.insurence.management.repo.Clientrepository;
import com.insurence.management.repo.InsurencePolicyRepository;
import com.insurence.management.service.ClientService;

@Service
@Transactional
public class ClientServiceImple implements ClientService {
	
	@Autowired
	private Clientrepository clientRepo;
	
	@Autowired
	private InsurencePolicyRepository policyRepository;

	@Override
	public ApiResponse getAllClient() {
		// TODO Auto-generated method stub
		return new ApiResponse(HttpStatus.OK, "all clients Result", clientRepo.findAll());

	}

	@Override
	public ApiResponse getClientById(Long id) {
		// TODO Auto-generated method stub
		Optional<Client> client = clientRepo.findById(id);
		if (client.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "client is not fount for above id " + id);
		}
		return new ApiResponse(HttpStatus.OK, " clients Result", client);
	}

	@Override
	public ApiResponse addAllClient(Client client) {
		// TODO Auto-generated method stub
		Optional<Client> clientDao = clientRepo.findByEmail(client.getEmail());
		if (clientDao.isPresent()) {
			return new ApiResponse(HttpStatus.OK, "email allredy exist");
		}
		return new ApiResponse(HttpStatus.OK, "clients Result added", clientRepo.save(client));
	}

	@Override
	public ApiResponse updateClientBuyId(Long id, Client dto) {
		// TODO Auto-generated method stub
		Optional<Client> client = clientRepo.findById(id);
		if (client.isEmpty()) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "client not found for above id: " + id);
		}
		client.get().setName(dto.getName());
		client.get().setEmail(dto.getEmail());
		client.get().setAddress(dto.getAddress());
		client.get().setContactNo(dto.getContactNo());
		client.get().setDateOfBirth(dto.getDateOfBirth());

		return new ApiResponse(HttpStatus.OK, "Result updated Succesfuly...", client);
	}

	@Override
	public ApiResponse deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<InsurancePolicy> policy = policyRepository.findByClientId(id);
		if (policy.isPresent()) {
			policy.get().setClient(null);
			policyRepository.save(policy.get());
		}

		if (!clientRepo.existsById(id)) {
			return new ApiResponse(HttpStatus.NOT_FOUND, "result not found for this id: " + id);
		}
		clientRepo.deleteById(id);

		return new ApiResponse(HttpStatus.OK, "client deleted successfuly.. ");
	}
	

}
