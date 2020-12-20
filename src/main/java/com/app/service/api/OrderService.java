package com.app.service.api;

import com.app.model.dto.OrderDto;
import com.app.model.entity.OrderEntity;
import java.util.List;

public interface OrderService
{
	void addOrder(OrderDto orderDto);

	OrderEntity findOrderById(long id);

	void deleteOrder(OrderDto orderDto);

	List<OrderEntity> findAllOrder();
}
