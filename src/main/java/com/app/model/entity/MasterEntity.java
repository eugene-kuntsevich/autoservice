package com.app.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "master")
public class MasterEntity extends PersistableEntityImpl
{
	private String firstName;
	private String secondName;
	private Set<OrderEntity> orderEntity;

	@Column(name = "first_name", length = 300)
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	@Column(name = "secondName", length = 300)
	public String getSecondName()
	{
		return secondName;
	}

	public void setSecondName(String secondName)
	{
		this.secondName = secondName;
	}

	@ManyToMany(targetEntity = OrderEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "master_order", joinColumns = {@JoinColumn(name = "master_id")},
		inverseJoinColumns = {@JoinColumn(name = "order_id")})
	public Set<OrderEntity> getOrderEntity()
	{
		return orderEntity;
	}

	public void setOrderEntity(Set<OrderEntity> orderEntity)
	{
		this.orderEntity = orderEntity;
	}
}
