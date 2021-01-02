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
    private CarConverter carConverter;

    @Override
    public void addCar(CarDto carDto) {
        CarEntity carEntity = carConverter.convertFromDtoToEntity(carDto);
        carDao.saveOrUpdate(carEntity);
    }

    @Override
    public CarDto findCarById(long id) {
        CarEntity carEntity = carDao.getById(id);
        return carConverter.convertFromEntityToDto(carEntity);
    }

    @Override
    public void deleteCar(CarDto carDto) {
        CarEntity carEntity = carConverter.convertFromDtoToEntity(carDto);
        carDao.delete(carEntity);
    }

    @Override
    public void deleteCarById(long carId) {
        carDao.deleteById(carId);
    }

    @Override
    public List<CarDto> findAllCars() {
        List<CarEntity> carEntities = carDao.getAll();
        return carConverter.convertFromEntitiesToDtos(carEntities);
    }

    @Override
    public CarDto getCarByNumber(String number) {
        CarEntity carEntity = carDao.getCarByNumber(number);
        return carConverter.convertFromEntityToDto(carEntity);
    }

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Autowired
    public void setCarConverter(CarConverter carConverter) {
        this.carConverter = carConverter;
    }
}
