package com.app.model.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.api.OrderDao;
import com.app.model.api.Converter;
import com.app.model.dto.MasterDto;
import com.app.model.dto.OrderDto;
import com.app.model.entity.MasterEntity;
import com.app.model.entity.OrderEntity;

@Component
public class OrderConverter implements Converter<OrderDto, OrderEntity> {

    private OrderDao orderDao;
    private ClientConverter clientConverter;
    private OrderStatusConverter orderStatusConverter;
    private CarConverter carConverter;
    private MasterConverter masterConverter;

    @Override
    public OrderDto convertFromEntityToDto(OrderEntity entity) {
        OrderDto orderDto = new OrderDto();

        orderDto.setClientDto(clientConverter.convertFromEntityToDto(entity.getClientEntity()));
        orderDto.setOrderStatusDto(orderStatusConverter.convertFromEntityToDto(entity.getOrderStatusEntity()));
        orderDto.setCarDto(carConverter.convertFromEntityToDto(entity.getCarEntity()));

        List<MasterDto> mastersDto = new MasterConverter().convertFromEntitiesToDtos(entity.getMasterEntity());
        orderDto.setMastersDto(mastersDto);

        return orderDto;
    }

    @Override
    public OrderEntity convertFromDtoToEntity(OrderDto dto) {
        Long id = dto.getId();
        OrderEntity orderEntity = ( id != null ) ? orderDao.getById(id) : new OrderEntity();

        orderEntity.setClientEntity(clientConverter.convertFromDtoToEntity(dto.getClientDto()));
        orderEntity.setOrderStatusEntity(orderStatusConverter.convertFromDtoToEntity(dto.getOrderStatusDto()));
        orderEntity.setCarEntity(carConverter.convertFromDtoToEntity(dto.getCarDto()));

        List<MasterEntity> masterEntities = new MasterConverter().convertFromDtosToEntities(dto.getMastersDto());
        orderEntity.setMasterEntity(masterEntities);

        return orderEntity;
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Autowired
    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }

    @Autowired
    public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter) {
        this.orderStatusConverter = orderStatusConverter;
    }

    @Autowired
    public void setCarConverter(CarConverter carConverter) {
        this.carConverter = carConverter;
    }

    @Autowired
    public void setMasterConverter(MasterConverter masterConverter) {
        this.masterConverter = masterConverter;
    }
}
