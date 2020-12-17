package com.app.model.converter;

import com.app.model.dto.CarDto;
import com.app.model.entity.CarEntity;

public class CarConverter
{
	public static CarDto convertFromEntityToDto(CarEntity entity)
	{
		CarDto carDto = new CarDto();
		carDto.setCarNumber(entity.getCarNumber() != null ? entity.getCarNumber() : "");
		carDto.setWarrantyDate(entity.getWarrantyDate());
		//carDto.setOrderDto(OrderConverter.convertFromEntityToDto(entity.getOrderEntity));
		return carDto;
		//return new CarDto(entity.getCarNumber(), entity.getWarrantyDate());
	}

	public static CarEntity convertFromDtoToEntity(CarDto dto)
	{
		return null;
	}
}
