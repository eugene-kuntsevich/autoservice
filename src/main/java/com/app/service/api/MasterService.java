package com.app.service.api;

import java.util.List;

import com.app.model.entity.MasterEntity;

public interface MasterService
{
	void addMaster(MasterEntity masterEntity);

	MasterEntity findMasterById(long id);

	void deleteMaster(MasterEntity masterEntity);

	List<MasterEntity> findAllMasters();
}
