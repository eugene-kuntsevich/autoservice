package com.app.service;

import java.util.List;

import com.app.model.converter.MasterConverter;
import com.app.model.dto.MasterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.api.MasterDao;
import com.app.model.entity.MasterEntity;
import com.app.service.api.MasterService;

@Service
public class MasterServiceImpl implements MasterService
{
	private MasterDao masterDao;

	public void addMaster(MasterDto masterDto)
	{
		MasterEntity masterEntity = MasterConverter.convertFromDtoToEntity(masterDto);
		masterDao.saveOrUpdate(masterEntity);
	}

	public MasterEntity findMasterById(long id)
	{
		return masterDao.getById(id);
	}

	public void deleteMaster(MasterDto masterDto)
	{
		MasterEntity masterEntity = MasterConverter.convertFromDtoToEntity(masterDto);
		masterDao.delete(masterEntity);
	}

	public List<MasterEntity> findAllMasters()
	{

		return masterDao.getAll();
	}

	@Autowired
	public void setMasterDao(MasterDao masterDao)
	{
		this.masterDao = masterDao;
	}
}
