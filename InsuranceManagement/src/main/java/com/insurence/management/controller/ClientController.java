package com.insurence.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurence.management.entites.Client;
import com.insurence.management.model.ApiResponse;
import com.insurence.management.service.ClientService;

@RestController
@RequestMapping("api/clients")
@Transactional
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping()
	public ApiResponse getAllClient() {
		return clientService.getAllClient();
	}

	@GetMapping("/{id}")
	public ApiResponse getClientById(@PathVariable Long id) {

		return clientService.getClientById(id);

	}

	@PostMapping()
	public ApiResponse addAllClient(@RequestBody Client client) {

		return clientService.addAllClient(client);

	}

	@PutMapping("/{id}")
	public ApiResponse updateClientBuyId(@PathVariable Long id, @RequestBody Client dto) {

		return clientService.updateClientBuyId(id, dto);

	}

	@DeleteMapping("/delete/{id}")
	public ApiResponse deleteById(@PathVariable Long id) {

		return clientService.deleteById(id);

	}
}