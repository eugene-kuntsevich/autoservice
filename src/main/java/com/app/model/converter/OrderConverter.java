package com.app.model.converter;

import com.app.model.dto.MasterDto;
import com.app.model.dto.OrderDto;
import com.app.model.entity.MasterEntity;
import com.app.model.entity.OrderEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderConverter {
    public static OrderDto convertFromEntityToDto(OrderEntity entity) {

        OrderDto orderDto = new OrderDto();

        orderDto.setClientDto(ClientConverter.convertFromEntityToDto(entity.getClientEntity()));
        orderDto.setOrderStatusDto(OrderStatusConverter.convertFromEntityToDto(entity.getOrderStatusEntity()));
        orderDto.setCarDto(CarConverter.convertFromEntityToDto(entity.getCarEntity()));

        Set<MasterDto> mastersDto = new HashSet<>();
        Set<MasterEntity> mastersEntity = entity.getMasterEntity();

        for (MasterEntity masterEntity : mastersEntity) {
            mastersDto.add(MasterConverter.convertFromEntityToDto(masterEntity));
        }
        orderDto.setMastersDto(mastersDto);

        return orderDto;
    }

    public static OrderEntity convertFromDtoToEntity(OrderDto dto) {

        OrderEntity orderEntity = new OrderEntity();
        Set<MasterEntity> masterEntities = new HashSet<>();
        if (dto != null)
        {
            orderEntity.setClientEntity(ClientConverter.convertFromDtoToEntity(dto.getClientDto()));
            orderEntity.setOrderStatusEntity(OrderStatusConverter.convertFromDtoToEntity(dto.getOrderStatusDto()));
            orderEntity.setCarEntity(CarConverter.convertFromDtoToEntity(dto.getCarDto()));
            Set<MasterDto> mastersDto = dto.getMastersDto();
            if (mastersDto != null)
            {
                for (MasterDto masterDto : mastersDto)
                {
                    masterEntities.add(MasterConverter.convertFromDtoToEntity(masterDto));
                }
            }
        }
        orderEntity.setMasterEntity(masterEntities);
        return orderEntity;
    }

    public static Set<OrderEntity> convertFromDtosToEntities(Set<OrderDto> dtos) {
//        Set<OrderEntity> result = new HashSet<>();
//        for (OrderDto dto : dtos)
//        {
//            OrderEntity orderEntity = convertFromDtoToEntity(dto);
//            result.add(orderEntity);
//        }
//        return result;
      return dtos.stream().map(OrderConverter::convertFromDtoToEntity).collect(Collectors.toSet());
    }
}
