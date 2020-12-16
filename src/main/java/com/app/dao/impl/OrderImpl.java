package com.app.dao.impl;

import com.app.dao.AbstractDao;
import com.app.dao.api.OrderDao;
import com.app.model.entity.OrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderImpl extends AbstractDao<OrderEntity> implements OrderDao
{
	public OrderImpl()
	{
		super(OrderEntity.class);
	}
}
