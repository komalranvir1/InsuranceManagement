package com.insurence.management.service;

import com.insurence.management.entites.Client;
import com.insurence.management.model.ApiResponse;

public interface ClientService {

	ApiResponse getAllClient();

	ApiResponse getClientById(Long id);

	ApiResponse addAllClient(Client client);

	ApiResponse updateClientBuyId(Long id, Client dto);

	ApiResponse deleteById(Long id);

}
