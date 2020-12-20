package com.app.model.converter;

import com.app.model.dto.ClientDto;
import com.app.model.dto.OrderDto;
import com.app.model.entity.ClientEntity;
import com.app.model.entity.OrderEntity;

import java.util.HashSet;
import java.util.Set;

public class ClientConverter {
    public static ClientDto convertFromEntityToDto(ClientEntity entity) {
        ClientDto clientDto = new ClientDto();

        clientDto.setFirstName(entity.getFirstName());
        clientDto.setSecondName(entity.getSecondName());
        clientDto.setEmail(entity.getEmail());

        Set<OrderDto> ordersDto = new HashSet<>();
        Set<OrderEntity> ordersEntity = entity.getOrderEntities();

        for (OrderEntity orderEntity : ordersEntity) {
            ordersDto.add(OrderConverter.convertFromEntityToDto(orderEntity));
        }
        clientDto.setOrdersDto(ordersDto);

        return clientDto;
    }

    public static ClientEntity convertFromDtoToEntity(ClientDto dto) {

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setFirstName(dto.getFirstName());
        clientEntity.setSecondName(dto.getSecondName());
        clientEntity.setEmail(dto.getEmail());

        Set<OrderEntity> orderEntities = new HashSet<>();
        Set<OrderDto> ordersDto = dto.getOrdersDto();
        if (ordersDto != null)
        {
            for (OrderDto orderDto : ordersDto) {
                orderEntities.add(OrderConverter.convertFromDtoToEntity(orderDto));
            }
        }

        clientEntity.setOrderEntities(orderEntities);
        return clientEntity;
    }
}
