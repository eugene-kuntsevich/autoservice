package com.app.service;

import com.app.model.entity.PersistableEntity;
import com.app.model.entity.PersistableEntityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.api.MasterDao;
import com.app.model.entity.MasterEntity;

import java.util.List;

@Service
public class MasterService {
	private MasterDao masterDao;



	public void saveMaster(MasterEntity masterEntity) {
		masterDao.saveOrUpdate(masterEntity);
	}
	public MasterEntity getMasterById(long id){
		return masterDao.get(id);
	}

	public void deleteMaster(MasterEntity masterEntity) {
		masterDao.delete(masterEntity);
	}
	public List<MasterEntity> findAllMasters() {

		return masterDao.list();
	}

    /*public void addUser(MasterEntity masterEntity)
    {
        masterEntity.setFirstName(masterEntity.getFirstName()+123);
        masterEntity.setSecondName(masterEntity.getSecondName());
        masterDao.saveOrUpdate(masterEntity);
    }
*/

	@Autowired
	public void setMasterDao(MasterDao masterDao) {
		this.masterDao = masterDao;
	}
}
