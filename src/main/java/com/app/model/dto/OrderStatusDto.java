package com.app.model.dto;


import java.util.Set;

public class OrderStatusDto {
    private String name;
    private Set<OrderDto> ordersDto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<OrderDto> getOrdersDto() {
        return ordersDto;
    }

    public void setOrdersDto(Set<OrderDto> ordersDto) {
        this.ordersDto = ordersDto;
    }
}
