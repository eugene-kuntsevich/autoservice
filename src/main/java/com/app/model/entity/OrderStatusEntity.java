package com.app.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "order_status")
public class OrderStatusEntity extends PersistableEntityImpl
{
	private String name;
	private Set<OrderEntity> orderEntities;

	@Column(name = "name", length = 300)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "orderStatusEntity", cascade = CascadeType.ALL)
	@JsonBackReference
	public Set<OrderEntity> getOrderEntities() {
		return orderEntities;
	}

	public void setOrderEntities(Set<OrderEntity> orderEntities) {
		this.orderEntities = orderEntities;
	}
}
