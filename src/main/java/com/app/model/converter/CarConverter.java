package com.app.model.converter;

import com.app.model.dto.CarDto;
import com.app.model.dto.OrderDto;
import com.app.model.entity.CarEntity;

public class CarConverter {
    public static CarDto convertFromEntityToDto(CarEntity entity) {
        CarDto carDto = new CarDto();

        carDto.setCarNumber(entity.getCarNumber() != null ? entity.getCarNumber() : "");
        carDto.setWarrantyDate(entity.getWarrantyDate());
        carDto.setOrderDto(OrderConverter.convertFromEntityToDto(entity.getOrderEntity()));

        return carDto;
    }

    public static CarEntity convertFromDtoToEntity(CarDto dto) {

        CarEntity carEntity = new CarEntity();

        carEntity.setCarNumber(dto.getCarNumber());
        carEntity.setWarrantyDate(dto.getWarrantyDate());
        OrderDto orderDto = dto.getOrderDto();
        if (orderDto != null)
        {
            carEntity.setOrderEntity(OrderConverter.convertFromDtoToEntity(orderDto));
        }

        return carEntity;
    }
}
