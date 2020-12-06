package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.api.MasterDao;
import com.app.model.entity.MasterEntity;

@Service
public class MasterService
{
	private MasterDao masterDao;

	public void addUser(MasterEntity masterEntity)//saveMaster
	{
		masterEntity.setFirstName(masterEntity.getFirstName() + "123");
		masterEntity.setSecondName(masterEntity.getSecondName().toUpperCase());
		masterDao.saveOrUpdate(masterEntity);
	}


	@Autowired
	public void setMasterDao(MasterDao masterDao)
	{
		this.masterDao = masterDao;
	}
}
