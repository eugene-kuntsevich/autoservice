package com.app.model.dto;

import java.util.Set;

public class OrderDto {
    private ClientDto clientDto;
    private OrderStatusDto orderStatusDto;
    private CarDto carDto;
    private Set<MasterDto> mastersDto;

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

    public Set<MasterDto> getMastersDto() {
        return mastersDto;
    }

    public void setMastersDto(Set<MasterDto> mastersDto) {
        this.mastersDto = mastersDto;
    }
}
