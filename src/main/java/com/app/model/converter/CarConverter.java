package com.app.model.converter;

import com.app.model.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.api.CarDao;
import com.app.model.api.Converter;
import com.app.model.dto.CarDto;
import com.app.model.dto.OrderDto;
import com.app.model.entity.CarEntity;

import java.util.List;

@Component
public class CarConverter implements Converter<CarDto, CarEntity> {

    private CarDao carDao;
    private OrderConverter orderConverter;
    private ClientConverter clientConverter;
    private OrderStatusConverter orderStatusConverter;

    @Override
    public CarDto convertFromEntityToDto(CarEntity entity) {
        CarDto carDto = new CarDto();

        if (entity != null) {
            carDto.setCarNumber(entity.getCarNumber() != null ? entity.getCarNumber() : "");
            carDto.setWarrantyDate(entity.getWarrantyDate());
            //carDto.setOrderDto(orderConverter.convertFromEntityToDto(entity.getOrderEntity()));

            OrderEntity orderEntity = entity.getOrderEntity();
            OrderDto orderDto = new OrderDto();
            orderDto.setClientDto(clientConverter.convertFromEntityToDto(orderEntity.getClientEntity()));
            orderDto.setOrderStatusDto(orderStatusConverter.convertFromEntityToDto(orderEntity.getOrderStatusEntity()));

            carDto.setOrderDto(orderDto);

        }

        return carDto;
    }

    @Override
    public CarEntity convertFromDtoToEntity(CarDto dto) {
        Long id = dto.getId();
        CarEntity carEntity = (id != null) ? carDao.getById(id) : new CarEntity();

        carEntity.setCarNumber(dto.getCarNumber());
        carEntity.setWarrantyDate(dto.getWarrantyDate());
        OrderDto orderDto = dto.getOrderDto();
        if (orderDto != null) {
            carEntity.setOrderEntity(orderConverter.convertFromDtoToEntity(orderDto));
        }

        return carEntity;
    }

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Autowired
    public void setOrderConverter(OrderConverter orderConverter) {
        this.orderConverter = orderConverter;
    }
}
