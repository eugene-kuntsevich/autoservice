package com.app.service.api;

import com.app.model.entity.ClientEntity;

import java.util.List;

public interface ClientService
{
	void addClient(ClientEntity ClientEntity);

	ClientEntity findClientById(long id);

	void deleteClient(ClientEntity ClientEntity);

	List<ClientEntity> findAllClient();
}
