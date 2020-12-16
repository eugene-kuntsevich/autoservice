package com.app.service.api;

import com.app.model.entity.CarEntity;

import java.util.List;

public interface CarService
{
	void addCar(CarEntity carEntity);

	CarEntity findCarById(long id);

	void deleteCar(CarEntity carEntity);

	List<CarEntity> findAllCars();
}
