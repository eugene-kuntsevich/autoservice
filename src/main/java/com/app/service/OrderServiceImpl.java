package com.app.service;

import com.app.dao.api.OrderDao;
import com.app.model.converter.OrderConverter;
import com.app.model.dto.OrderDto;
import com.app.model.entity.OrderEntity;
import com.app.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Override
    public void addOrder(OrderDto orderDto) {
        OrderEntity orderEntity = OrderConverter.convertFromDtoToEntity(orderDto);
        orderDao.saveOrUpdate(orderEntity);
    }

    @Override
    public OrderEntity findOrderById(long id) {
        return orderDao.getById(id);
    }

    @Override
    public void deleteOrder(OrderDto orderDto) {
        OrderEntity orderEntity = OrderConverter.convertFromDtoToEntity(orderDto);
        orderDao.delete(orderEntity);
    }

    @Override
    public List<OrderEntity> findAllOrder() {
        return orderDao.getAll();
    }

    @Autowired
    public void setOrder(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}