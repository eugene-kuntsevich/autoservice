package com.app.dao.api;

import com.app.model.entity.CarEntity;

import java.util.List;

public interface CarDao extends GenericDao<CarEntity> {

	CarEntity getCarByNumber(String number);

    List<CarEntity> getCarsEqualStatus(long id);
}
