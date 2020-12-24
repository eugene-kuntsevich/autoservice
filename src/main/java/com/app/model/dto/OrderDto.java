package com.app.model.dto;

import java.util.List;

import com.app.model.api.Dto;

public class OrderDto  implements Dto
{
    private Long id;
    private ClientDto clientDto;
    private OrderStatusDto orderStatusDto;
    private CarDto carDto;
    private List<MasterDto> mastersDto;

    @Override
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public ClientDto getClientDto() {
        return clientDto;
    }

    public void setClientDto(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public OrderStatusDto getOrderStatusDto() {
        return orderStatusDto;
    }

    public void setOrderStatusDto(OrderStatusDto orderStatusDto) {
        this.orderStatusDto = orderStatusDto;
    }

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }

    public List<MasterDto> getMastersDto()
    {
        return mastersDto;
    }

    public void setMastersDto(List<MasterDto> mastersDto)
    {
        this.mastersDto = mastersDto;
    }
}
