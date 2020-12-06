package com.app.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class CarEntity extends PersistableEntityImpl
{
	//	private String firstName;
//	private String secondName;
//
//	@Column(name = "first_name", length = 300)
//	public String getFirstName()
//	{
//		return firstName;
//	}
//
//	public void setFirstName(String firstName)
//	{
//		this.firstName = firstName;
//	}
//
//	@Column(name = "secondName", length = 300)
//	public String getSecondName()
//	{
//		return secondName;
//	}
//
//	public void setSecondName(String secondName)
//	{
//		this.secondName = secondName;
//	}

	private ClientEntity clientEntity;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="clientId")
	public ClientEntity getClientEntity()
	{
		return clientEntity;
	}

	public void setClientEntity(ClientEntity clientEntity)
	{
		this.clientEntity = clientEntity;
	}
}
