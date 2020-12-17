package com.app.model.dto;

import java.util.Date;

public class CarDto
{
	private String carNumber;
	private Date warrantyDate;
	//private OrderDto orderDto;

	public CarDto()
	{
	}

	public CarDto(String carNumber, Date warrantyDate)
	{
		this.carNumber = carNumber;
		this.warrantyDate = warrantyDate;
	}

	public String getCarNumber()
	{
		return carNumber;
	}

	public void setCarNumber(String carNumber)
	{
		this.carNumber = carNumber;
	}

	public Date getWarrantyDate()
	{
		return warrantyDate;
	}

	public void setWarrantyDate(Date warrantyDate)
	{
		this.warrantyDate = warrantyDate;
	}
}
