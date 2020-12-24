package com.app.model.dto;

import java.util.List;

import com.app.model.api.Dto;

public class MasterDto implements Dto {
	private Long id;
	private String firstName;
	private String secondName;
	private List<OrderDto> ordersDto;

	@Override
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getSecondName()
	{
		return secondName;
	}

	public void setSecondName(String secondName)
	{
		this.secondName = secondName;
	}

	public List<OrderDto> getOrdersDto()
	{
		return ordersDto;
	}

	public void setOrdersDto(List<OrderDto> ordersDto)
	{
		this.ordersDto = ordersDto;
	}
}
