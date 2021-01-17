package com.app.service;

import java.util.List;

import com.app.exception.NotUniqueStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.api.OrderDao;
import com.app.model.converter.OrderConverter;
import com.app.model.dto.OrderDto;
import com.app.model.entity.OrderEntity;
import com.app.service.api.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private OrderConverter orderConverter;

    @Override
    public void saveOrder(OrderDto orderDto) throws NotUniqueStatusException {
        //Достаём объект из БД с id соответствующему запросу
        OrderEntity orderEntity1 = orderDao.getById(orderDto.getId());
        if (orderEntity1 == null) {
            OrderEntity orderEntity = orderConverter.convertFromDtoToEntity(orderDto);
            orderDao.saveOrUpdate(orderEntity);
        } else {
            if (checkOrderStatus(orderDto)) {
                OrderEntity orderEntity = orderConverter.convertFromDtoToEntity(orderDto);
                orderDao.saveOrUpdate(orderEntity);
            } else {
                throw new NotUniqueStatusException("Introduced illegal car status");
            }
        }
    }

    @Override
    public OrderDto findOrderById(long id) {
        OrderEntity orderEntity = orderDao.getById(id);
        return orderConverter.convertFromEntityToDto(orderEntity);
    }

    @Override
    public void deleteOrder(OrderDto orderDto) {
        OrderEntity orderEntity = orderConverter.convertFromDtoToEntity(orderDto);
        orderDao.delete(orderEntity);
    }

    @Override
    public void deleteOrderById(long orderId) {
        orderDao.deleteById(orderId);
    }

    @Override
    public List<OrderDto> findAllOrder() {
        List<OrderEntity> orderEntities = orderDao.getAll();
        return orderConverter.convertFromEntitiesToDtos(orderEntities);
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Autowired
    public void setOrderConverter(OrderConverter orderConverter) {
        this.orderConverter = orderConverter;
    }

    private boolean checkOrderStatus(OrderDto orderDto) {
        OrderEntity orderEntity = orderDao.getById(orderDto.getId());
        long dtoId = orderDto.getOrderStatusDto().getId();
        long entityId = orderEntity.getOrderStatusEntity().getId();

        return entityId == dtoId
                || (entityId == 1 && dtoId == 2)
                || (entityId == 2 && dtoId == 3)
                || (entityId == 2 && dtoId == 4)
                || (entityId == 3 && dtoId == 2)
                || dtoId == 5;
    }
}

/*
 @Override
    public void saveOrder(OrderDto orderDto) throws NotUniqueStatusException {
        if (checkOrderStatus(orderDto)) {
            OrderEntity orderEntity = orderConverter.convertFromDtoToEntity(orderDto);
            orderDao.saveOrUpdate(orderEntity);
        } else {
            throw new NotUniqueStatusException("Introduced illegal car status");
        }
    }

    private boolean checkOrderStatus(OrderDto orderDto) {
        OrderEntity orderEntity = orderDao.getById(orderDto.getId());
        long dtoId = orderDto.getOrderStatusDto().getId();
        long entityId = orderEntity.getOrderStatusEntity().getId();

        return entityId == dtoId
            || ( entityId == 1 && dtoId == 2 )
            || ( entityId == 2 && dtoId == 3 )
            || ( entityId == 2 && dtoId == 4 )
            || ( entityId == 3 && dtoId == 2 )
            || dtoId == 5;
    }



    Моя реализация
    @Override
    public void saveOrder(OrderDto orderDto) throws NotUniqueStatusException {
        //Достаём объект из БД с id соответствующему запросу
        OrderEntity orderEntity1 = orderDao.getById(orderDto.getId());
        if (orderEntity1 == null) {
            OrderEntity orderEntity = orderConverter.convertFromDtoToEntity(orderDto);
            orderDao.saveOrUpdate(orderEntity);
        } else {
            if (checkOrderStatus(orderDto)) {
                OrderEntity orderEntity = orderConverter.convertFromDtoToEntity(orderDto);
                orderDao.saveOrUpdate(orderEntity);
            } else {
                throw new NotUniqueStatusException("Introduced illegal car status");
            }
        }
 */