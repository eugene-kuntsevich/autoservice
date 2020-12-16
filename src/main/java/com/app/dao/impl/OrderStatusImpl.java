package com.app.dao.impl;

import com.app.dao.AbstractDao;
import com.app.dao.api.OrderStatusDao;
import com.app.model.entity.OrderStatusEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderStatusImpl extends AbstractDao<OrderStatusEntity> implements OrderStatusDao
{
	public OrderStatusImpl()
	{
		super(OrderStatusEntity.class);
	}
}
