package com.app.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.app.model.dto.MasterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.api.OrderStatusDao;
import com.app.model.api.Converter;
import com.app.model.dto.OrderDto;
import com.app.model.dto.OrderStatusDto;
import com.app.model.entity.OrderEntity;
import com.app.model.entity.OrderStatusEntity;

@Component
public class OrderStatusConverter implements Converter<OrderStatusDto, OrderStatusEntity> {

    private OrderStatusDao orderStatusDao;
    private OrderConverter orderConverter;
    /*private ClientConverter clientConverter;
    private CarConverter carConverter;
    private MasterConverter masterConverter;*/

    @Override
    public OrderStatusDto convertFromEntityToDto(OrderStatusEntity entity) {
        OrderStatusDto orderStatusDto = new OrderStatusDto();

        if (entity != null) {
            orderStatusDto.setId(entity.getId());

            orderStatusDto.setName(entity.getName());
            /*List<OrderEntity> orderEntities = entity.getOrderEntities();
            List<OrderDto> ordersDtos = orderEntities.stream().map(orderEntity -> {
                OrderDto orderDto = new OrderDto();
                orderDto.setCarDto(carConverter.convertFromEntityToDto(orderEntity.getCarEntity()));
                orderDto.setClientDto(clientConverter.convertFromEntityToDto(orderEntity.getClientEntity()));

                List<MasterDto> mastersDto = masterConverter.convertFromEntitiesToDtos(orderEntity.getMasterEntity());
                orderDto.setMastersDto(mastersDto);

                return orderDto;
            }).collect(Collectors.toList());
            orderStatusDto.setOrdersDto(ordersDtos);*/

        /*List<OrderDto> ordersDto = orderConverter.convertFromEntitiesToDtos(entity.getOrderEntities());
        orderStatusDto.setOrdersDto(ordersDto);*/
        }

        return orderStatusDto;
    }

    @Override
    public OrderStatusEntity convertFromDtoToEntity(OrderStatusDto dto) {
        Long id = dto.getId();
        OrderStatusEntity orderStatusEntity = (id != null) ? orderStatusDao.getById(id) : new OrderStatusEntity();

        orderStatusEntity.setName(dto.getName());

        List<OrderEntity> orderEntities = orderConverter.convertFromDtosToEntities(dto.getOrdersDto());
        orderStatusEntity.setOrderEntities(orderEntities);

        return orderStatusEntity;
    }

    @Autowired
    public void setOrderStatusDao(OrderStatusDao orderStatusDao) {
        this.orderStatusDao = orderStatusDao;
    }

       @Autowired
    public void orderCarConverter(OrderConverter orderConverter) {
        this.orderConverter = orderConverter;
    }

    /*@Autowired
    public void setMasterConverter(MasterConverter masterConverter) {
        this.masterConverter = masterConverter;
    }

    @Autowired
    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }

    @Autowired
    public void setCarConverter(CarConverter carConverter) {
        this.carConverter = carConverter;
    }*/
}
