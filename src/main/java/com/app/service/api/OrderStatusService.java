package com.app.service.api;

import com.app.model.entity.OrderStatusEntity;
import java.util.List;

public interface OrderStatusService
{
	void addOrderStatus(OrderStatusEntity orderStatusEntity);

	OrderStatusEntity findOrderStatusById(long id);

	void deleteOrderStatus(OrderStatusEntity orderStatusEntity);

	List<OrderStatusEntity> findAllOrderStatus();
}
