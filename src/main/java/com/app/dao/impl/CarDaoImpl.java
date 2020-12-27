package com.app.dao.impl;

import com.app.dao.AbstractDao;
import com.app.dao.api.CarDao;
import com.app.model.entity.CarEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity> implements CarDao {

    public CarDaoImpl() {
        super(CarEntity.class);
    }

    @Override
    public CarEntity getCarByNumber(String number) {
        return null;
    }
}
