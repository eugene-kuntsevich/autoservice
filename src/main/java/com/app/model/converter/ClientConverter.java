package com.app.model.converter;

import java.util.List;
import java.util.stream.Collectors;

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
    private CarConverter carConverter;
    private ClientConverter clientConverter;
    private OrderStatusConverter orderStatusConverter;

    @Override
    public ClientDto convertFromEntityToDto(ClientEntity entity) {
        ClientDto clientDto = new ClientDto();

        if (entity != null) {
            clientDto.setId(entity.getId());
            clientDto.setFirstName(entity.getFirstName());
            clientDto.setSecondName(entity.getSecondName());
            clientDto.setEmail(entity.getEmail());

//            List<OrderEntity> orderEntities = entity.getOrderEntities();
//            List<OrderDto> ordersDtos = orderEntities.stream().map(orderEntity -> {
//                OrderDto orderDto = new OrderDto();
//                orderDto.setCarDto(carConverter.convertFromEntityToDto(orderEntity.getCarEntity()));
//                orderDto.setClientDto(clientConverter.convertFromEntityToDto(orderEntity.getClientEntity()));
//                orderDto.setOrderStatusDto(orderStatusConverter.convertFromEntityToDto(orderEntity.getOrderStatusEntity()));
//                return orderDto;
//            }).collect(Collectors.toList());
//
//            clientDto.setOrdersDto(ordersDtos);
        }
        return clientDto;
    }

    @Override
    public ClientEntity convertFromDtoToEntity(ClientDto dto) {

        Long id = dto.getId();
        ClientEntity clientEntity = null;
        if (id != null) {
            clientEntity = clientDao.getById(id);
            if (clientEntity == null) {
                clientEntity = new ClientEntity();
            }
        } else {
            clientEntity = new ClientEntity();
        }

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

    @Autowired
    public void setCarConverter(CarConverter carConverter) {
        this.carConverter = carConverter;
    }

    @Autowired
    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }

    @Autowired
    public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter) {
        this.orderStatusConverter = orderStatusConverter;
    }
}
