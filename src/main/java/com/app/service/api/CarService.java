package com.app.service.api;

import java.util.List;

import com.app.model.dto.CarDto;

public interface CarService
{
	void addCar(CarDto carDto);

	CarDto findCarById(long id);

	void deleteCar(CarDto carDto);

	void deleteCarById(long carId);

	List<CarDto> findAllCars();

	CarDto getCarByNumber(String number);

    List<CarDto> findCarsEqualStatus(long id);
}
