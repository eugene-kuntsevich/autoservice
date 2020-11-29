package com.app.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.model.MasterEntity;

@Repository
@Transactional
public class MasterDao
{
	private EntityManager entityManager;

	public void saveMaster(MasterEntity masterEntity)
	{
		entityManager.persist(masterEntity);
	}

	@Autowired
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
}
