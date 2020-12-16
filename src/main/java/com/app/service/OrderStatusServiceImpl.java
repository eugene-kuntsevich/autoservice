package com.app.service;

import com.app.dao.api.OrderStatusDao;
import com.app.model.entity.OrderStatusEntity;
import com.app.service.api.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    private OrderStatusDao orderStatusDao;

    @Override
    public void addOrderStatus(OrderStatusEntity orderStatusEntity) {
        orderStatusDao.saveOrUpdate(orderStatusEntity);
    }

    @Override
    public OrderStatusEntity findOrderStatusById(long id) {
        return orderStatusDao.getById(id);
    }

    @Override
    public void deleteOrderStatus(OrderStatusEntity orderStatusEntity) {
        orderStatusDao.delete(orderStatusEntity);
    }

    @Override
    public List<OrderStatusEntity> findAllOrderStatus() {
        return orderStatusDao.getAll();
    }

    @Autowired
    public void setOrderStatus(OrderStatusDao orderStatusDao) {
        this.orderStatusDao = orderStatusDao;
    }
}
