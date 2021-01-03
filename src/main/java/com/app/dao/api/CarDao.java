package com.app.dao.api;

import com.app.model.entity.CarEntity;

public interface CarDao extends GenericDao<CarEntity> {

	CarEntity getCarByNumber(String number);
}
