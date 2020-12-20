package com.app.service.api;

import com.app.model.dto.ClientDto;
import com.app.model.entity.ClientEntity;

import java.util.List;

public interface ClientService
{
	void addClient(ClientDto clientDto);

	ClientEntity findClientById(long id);

	void deleteClient(ClientDto clientDto);

	List<ClientEntity> findAllClient();
}
