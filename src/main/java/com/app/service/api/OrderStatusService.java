package com.app.service.api;

import com.app.model.dto.OrderStatusDto;
import com.app.model.entity.OrderStatusEntity;
import java.util.List;

public interface OrderStatusService
{
	void addOrderStatus(OrderStatusDto orderStatusDto);

	OrderStatusDto findOrderStatusById(long id);

	void deleteOrderStatus(OrderStatusDto orderStatusDto);

	List<OrderStatusDto> findAllOrderStatuses();
}
