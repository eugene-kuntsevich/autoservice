package com.app.service.api;

import java.util.List;

import com.app.model.dto.ClientDto;

public interface ClientService
{
	void addClient(ClientDto clientDto);

	ClientDto findClientById(long id);

	void deleteClient(ClientDto clientDto);

	void deleteClientById(long carId);

	List<ClientDto> findAllClient();
}
