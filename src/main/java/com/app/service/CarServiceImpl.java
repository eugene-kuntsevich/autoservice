package com.app.service;

import com.app.dao.api.CarDao;
import com.app.model.converter.CarConverter;
import com.app.model.dto.CarDto;
import com.app.model.entity.CarEntity;
import com.app.service.api.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private CarDao carDao;

    @Override
    public void addCar(CarDto carDto) {
        CarEntity carEntity = CarConverter.convertFromDtoToEntity(carDto);
        carDao.saveOrUpdate(carEntity);
    }

    @Override
    public CarEntity findCarById(long id) {
        return carDao.getById(id);
    }

    @Override
    public void deleteCar(CarEntity carEntity) {
        carDao.delete(carEntity);
    }

    @Override
    public List<CarEntity> findAllCars() {
        return carDao.getAll();
    }

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }
}
