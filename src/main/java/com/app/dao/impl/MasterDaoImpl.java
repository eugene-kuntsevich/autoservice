package com.app.dao.impl;

import org.springframework.stereotype.Repository;

import com.app.dao.AbstractDao;
import com.app.dao.api.MasterDao;
import com.app.model.entity.MasterEntity;

@Repository
public class MasterDaoImpl extends AbstractDao<MasterEntity> implements MasterDao
{
	public MasterDaoImpl()
	{
		super(MasterEntity.class);
	}
}
