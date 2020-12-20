package com.app.model.dto;

import java.util.Date;

public class CarDto {
    private String carNumber;
    private Date warrantyDate;
    private OrderDto orderDto;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Date getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(Date warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }
}
