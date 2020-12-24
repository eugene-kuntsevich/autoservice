package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.api.ClientDao;
import com.app.model.converter.ClientConverter;
import com.app.model.dto.ClientDto;
import com.app.model.entity.ClientEntity;
import com.app.service.api.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;
    private ClientConverter clientConverter;

    @Override
    public void addClient(ClientDto clientDto) {
        ClientEntity clientEntity = clientConverter.convertFromDtoToEntity(clientDto);
        clientDao.saveOrUpdate(clientEntity);
    }

    @Override
    public ClientDto findClientById(long id) {
        ClientEntity clientEntity = clientDao.getById(id);
        return clientConverter.convertFromEntityToDto(clientEntity);
    }

    @Override
    public void deleteClient(ClientDto clientDto) {
        ClientEntity clientEntity = clientConverter.convertFromDtoToEntity(clientDto);
        clientDao.delete(clientEntity);
    }

    @Override
    public List<ClientDto> findAllClient() {
        List<ClientEntity> clientEntities = clientDao.getAll();
        return clientConverter.convertFromEntitiesToDtos(clientEntities);
    }

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Autowired
    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }
}
