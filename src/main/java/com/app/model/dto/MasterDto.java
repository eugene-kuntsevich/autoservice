package com.app.model.dto;

import java.util.Set;

public class MasterDto {
    private String firstName;
    private String secondName;
    private Set<OrderDto> ordersDto;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Set<OrderDto> getOrdersDto() {
        return ordersDto;
    }

    public void setOrdersDto(Set<OrderDto> ordersDto) {
        this.ordersDto = ordersDto;
    }
}
