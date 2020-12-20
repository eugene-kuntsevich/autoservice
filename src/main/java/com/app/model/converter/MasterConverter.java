package com.app.model.converter;

import com.app.model.dto.MasterDto;
import com.app.model.dto.OrderDto;
import com.app.model.entity.MasterEntity;
import com.app.model.entity.OrderEntity;

import java.util.HashSet;
import java.util.Set;

public class MasterConverter {
    public static MasterDto convertFromEntityToDto(MasterEntity entity) {

        MasterDto masterDto = new MasterDto();

        masterDto.setFirstName(entity.getFirstName());
        masterDto.setSecondName(entity.getSecondName());

        Set<OrderDto> ordersDto = new HashSet<>();
        Set<OrderEntity> ordersEntity = entity.getOrderEntity();

        for (OrderEntity orderEntity : ordersEntity) {
            ordersDto.add(OrderConverter.convertFromEntityToDto(orderEntity));
        }
        masterDto.setOrdersDto(ordersDto);

        return masterDto;
    }

    public static MasterEntity convertFromDtoToEntity(MasterDto dto) {

        MasterEntity masterEntity = new MasterEntity();

        masterEntity.setFirstName(dto.getFirstName());
        masterEntity.setSecondName(dto.getSecondName());

        Set<OrderEntity> orderEntities = new HashSet<>();
        Set<OrderDto> ordersDto = dto.getOrdersDto();

        if (ordersDto != null) {
            for (OrderDto orderDto : ordersDto) {
                orderEntities.add(OrderConverter.convertFromDtoToEntity(orderDto));
            }
        }
        //Set<OrderEntity> orderEntities1 = OrderConverter.convertFromDtosToEntities(dto.getOrdersDto());

        masterEntity.setOrderEntity(orderEntities);
        return masterEntity;
        //return masterEntity.setOrderEntity(OrderConverter.convertFromDtosToEntities(dto.getOrdersDto());
    }
}
