package com.app.model.converter;

import com.app.model.dto.CarDto;
import com.app.model.dto.OrderDto;
import com.app.model.dto.OrderStatusDto;
import com.app.model.entity.OrderEntity;
import com.app.model.entity.OrderStatusEntity;

import java.util.HashSet;
import java.util.Set;

public class OrderStatusConverter {

    public static OrderStatusDto convertFromEntityToDto(OrderStatusEntity entity) {

        OrderStatusDto orderStatusDto = new OrderStatusDto();

        orderStatusDto.setName(entity.getName());

        Set<OrderDto> ordersDto = new HashSet<>();
        Set<OrderEntity> ordersEntity = entity.getOrderEntities();
        for (OrderEntity orderEntity : ordersEntity) {
            ordersDto.add(OrderConverter.convertFromEntityToDto(orderEntity));
        }
        orderStatusDto.setOrdersDto(ordersDto);

        return orderStatusDto;
    }

    public static OrderStatusEntity convertFromDtoToEntity(OrderStatusDto dto) {

        OrderStatusEntity orderStatusEntity = new OrderStatusEntity();

        orderStatusEntity.setName(dto.getName());

        Set<OrderEntity> orderEntities = new HashSet<>();
        Set<OrderDto> ordersDto = dto.getOrdersDto();
        if (ordersDto != null)
        {
            for (OrderDto orderDto : ordersDto) {
                orderEntities.add(OrderConverter.convertFromDtoToEntity(orderDto));
            }
        }

        orderStatusEntity.setOrderEntities(orderEntities);
        return orderStatusEntity;
    }
}
