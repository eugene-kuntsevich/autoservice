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
    private OrderConverter orderConverter;

    @Override
    public void saveOrder(OrderDto orderDto) throws Exception
    {
        OrderEntity orderEntity = orderConverter.convertFromDtoToEntity(orderDto);
        if (checkOrderStatus(orderDto))
        {
            orderDao.saveOrUpdate(orderEntity);
        }
        else {
            throw new Exception();
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

    private static boolean checkOrderStatus(OrderDto orderDto){
        return false;
    }
}
