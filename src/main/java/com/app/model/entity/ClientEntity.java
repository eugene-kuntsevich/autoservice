package com.app.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity extends PersistableEntityImpl
{
	private String firstName;
	private String secondName;
	private String email;
	private Set<OrderEntity> orderEntities;

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

	@Column(name = "email", length = 200)
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}


	@OneToMany(mappedBy = "clientEntity", cascade = CascadeType.ALL)
	@JsonBackReference
	public Set<OrderEntity> getOrderEntities() {
		return orderEntities;
	}

	public void setOrderEntities(Set<OrderEntity> orderEntities) {
		this.orderEntities = orderEntities;
	}

}