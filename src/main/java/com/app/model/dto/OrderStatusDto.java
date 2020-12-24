package com.app.model.dto;

import java.util.List;

import com.app.model.api.Dto;

public class OrderStatusDto  implements Dto
{
    private Long id;
    private String name;
    private List<OrderDto> ordersDto;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
