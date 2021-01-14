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
public class MasterServiceImpl implements MasterService {

	private MasterDao masterDao;
	private MasterConverter masterConverter;
	@Override
	public void addMaster(MasterDto masterDto)
	{
		MasterEntity masterEntity = masterConverter.convertFromDtoToEntity(masterDto);
		masterDao.saveOrUpdate(masterEntity);
	}
	@Override
	public MasterDto findMasterById(long id)
	{
		MasterEntity masterEntity = masterDao.getById(id);
		return masterConverter.convertFromEntityToDto(masterEntity);
	}
	@Override
	public void deleteMaster(MasterDto masterDto)
	{
		MasterEntity masterEntity = masterConverter.convertFromDtoToEntity(masterDto);
		masterDao.delete(masterEntity);
	}

	@Override
    public void deleteMasterById(long masterId) {
        masterDao.deleteById(masterId);
    }

	public List<MasterDto> findAllMasters()
	{
		List<MasterEntity> masterEntities = masterDao.getAll();
		return masterConverter.convertFromEntitiesToDtos(masterEntities);
	}
	@Override
	public List<MasterDto> getFreeMasters()
	{
		List<MasterEntity> masterEntities = masterDao.getFreeMasters();
		return masterConverter.convertFromEntitiesToDtos(masterEntities);
	}

	@Autowired
	public void setMasterDao(MasterDao masterDao) {
		this.masterDao = masterDao;
	}

	@Autowired
	public void setMasterConverter(MasterConverter masterConverter) {
		this.masterConverter = masterConverter;
	}
}
