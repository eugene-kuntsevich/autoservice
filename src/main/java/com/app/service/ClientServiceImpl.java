package com.app.service;

import com.app.dao.api.ClientDao;
import com.app.model.entity.ClientEntity;
import com.app.service.api.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;

    @Override
    public void addClient(ClientEntity clientEntity) {
        clientDao.saveOrUpdate(clientEntity);
    }

    @Override
    public ClientEntity findClientById(long id) {
        return clientDao.getById(id);
    }

    @Override
    public void deleteClient(ClientEntity clientEntity) {
        clientDao.delete(clientEntity);
    }

    @Override
    public List<ClientEntity> findAllClient() {
        return clientDao.getAll();
    }

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
}
