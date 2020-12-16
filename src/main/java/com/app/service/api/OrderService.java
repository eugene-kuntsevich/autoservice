package com.app.service.api;

import com.app.model.entity.OrderEntity;
import java.util.List;

public interface OrderService
{
	void addOrder(OrderEntity orderEntity);

	OrderEntity findOrderById(long id);

	void deleteOrder(OrderEntity orderEntity);

	List<OrderEntity> findAllOrder();
}
