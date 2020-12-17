package com.app.service.api;

import com.app.model.dto.CarDto;
import com.app.model.entity.CarEntity;

import java.util.List;

public interface CarService
{
	void addCar(CarDto carDto);

	CarEntity findCarById(long id);

	void deleteCar(CarEntity carEntity);

	List<CarEntity> findAllCars();
}
