package com.app.dao.impl;

import com.app.dao.AbstractDao;
import com.app.dao.api.ClientDao;
import com.app.model.entity.ClientEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl extends AbstractDao<ClientEntity> implements ClientDao {
    public ClientDaoImpl() {
        super(ClientEntity.class);
    }
}
