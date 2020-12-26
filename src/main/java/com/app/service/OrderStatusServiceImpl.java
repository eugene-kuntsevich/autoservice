package com.app.service;

import com.app.dao.api.OrderStatusDao;
import com.app.model.converter.OrderStatusConverter;
import com.app.model.dto.OrderStatusDto;
import com.app.model.entity.OrderStatusEntity;
import com.app.service.api.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    
    private OrderStatusDao orderStatusDao;
    private OrderStatusConverter orderStatusConverter;

    @Override
    public void addOrderStatus(OrderStatusDto orderStatusDto) {
        OrderStatusEntity orderStatusEntity = orderStatusConverter.convertFromDtoToEntity(orderStatusDto);
        orderStatusDao.saveOrUpdate(orderStatusEntity);
    }

    @Override
    public OrderStatusDto findOrderStatusById(long id) {
        OrderStatusEntity orderStatusEntity = orderStatusDao.getById(id);
        return orderStatusConverter.convertFromEntityToDto(orderStatusEntity);
    }

    @Override
    public void deleteOrderStatus(OrderStatusDto orderStatusDto) {
        OrderStatusEntity orderStatusEntity = orderStatusConverter.convertFromDtoToEntity(orderStatusDto);
        orderStatusDao.delete(orderStatusEntity);
    }

    @Override
    public void deleteOrderStatusById(long orderStatusId) {
        orderStatusDao.deleteById(orderStatusId);
    }

    @Override
    public List<OrderStatusDto> findAllOrderStatuses() {
        List<OrderStatusEntity> orderStatusEntities = orderStatusDao.getAll();
        return orderStatusConverter.convertFromEntitiesToDtos(orderStatusEntities);
    }

    @Autowired
    public void setOrderStatusDao(OrderStatusDao orderStatusDao) {
        this.orderStatusDao = orderStatusDao;
    }

    @Autowired
    public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter) {
        this.orderStatusConverter = orderStatusConverter;
    }
}
