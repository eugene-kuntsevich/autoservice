package com.app.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.app.model.api.PersistableEntity;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public class PersistableEntityImpl implements PersistableEntity
{
	private Long id;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	@Override
	public Long getId()
	{
		return id;
	}

	private void setId(Long id)
	{
		this.id = id;
	}
}
