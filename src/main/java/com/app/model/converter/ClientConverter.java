package com.app.model.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.api.ClientDao;
import com.app.model.api.Converter;
import com.app.model.dto.ClientDto;
import com.app.model.dto.OrderDto;
import com.app.model.entity.ClientEntity;
import com.app.model.entity.OrderEntity;

@Component
public class ClientConverter implements Converter<ClientDto, ClientEntity> {

    private ClientDao clientDao;
    private OrderConverter orderConverter;

    @Override
    public ClientDto convertFromEntityToDto(ClientEntity entity) {
        ClientDto clientDto = new ClientDto();

        if (entity != null) {

            clientDto.setFirstName(entity.getFirstName());
            clientDto.setSecondName(entity.getSecondName());
            clientDto.setEmail(entity.getEmail());

            List<OrderDto> ordersDto = orderConverter.convertFromEntitiesToDtos(entity.getOrderEntities());
            clientDto.setOrdersDto(ordersDto);
        }
        return clientDto;
    }

    @Override
    public ClientEntity convertFromDtoToEntity(ClientDto dto) {
        Long id = dto.getId();
        ClientEntity clientEntity = ( id != null ) ? clientDao.getById(id) : new ClientEntity();

        clientEntity.setFirstName(dto.getFirstName());
        clientEntity.setSecondName(dto.getSecondName());
        clientEntity.setEmail(dto.getEmail());

        List<OrderEntity> orderEntities = orderConverter.convertFromDtosToEntities(dto.getOrdersDto());
        clientEntity.setOrderEntities(orderEntities);

        return clientEntity;
    }

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Autowired
    public void setOrderConverter(OrderConverter orderConverter) {
        this.orderConverter = orderConverter;
    }
}
