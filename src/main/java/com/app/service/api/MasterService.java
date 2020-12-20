package com.app.service.api;

import java.util.List;

import com.app.model.dto.MasterDto;
import com.app.model.entity.MasterEntity;

public interface MasterService
{
	void addMaster(MasterDto masterDto);

	MasterEntity findMasterById(long id);

	void deleteMaster(MasterDto masterDto);

	List<MasterEntity> findAllMasters();
}
