package com.app.dao.api;

import java.util.List;

import com.app.model.entity.MasterEntity;

public interface MasterDao extends GenericDao<MasterEntity> {

	List<MasterEntity> getFreeMasters();
}
