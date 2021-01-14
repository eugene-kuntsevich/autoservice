package com.app.service.api;

import java.util.List;

import com.app.model.dto.MasterDto;

public interface MasterService
{
	void addMaster(MasterDto masterDto);

	MasterDto findMasterById(long id);

	void deleteMaster(MasterDto masterDto);

	void deleteMasterById(long masterId);

	List<MasterDto> findAllMasters();

    List<MasterDto> findFreeMasters();
}
