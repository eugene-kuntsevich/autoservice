package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "master")
public class MasterEntity
{
	private Long id;
	private String firstName;
//	private String secondName;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "first_name", length = 300)
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
}
