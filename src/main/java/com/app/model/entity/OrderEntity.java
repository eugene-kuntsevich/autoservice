package com.app.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "order_table")
public class OrderEntity extends PersistableEntityImpl {

    private ClientEntity clientEntity;
    private OrderStatusEntity orderStatusEntity;
    private CarEntity carEntity;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonManagedReference
    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    @ManyToOne
    @JoinColumn(name = "statusId")
    @JsonManagedReference
    public OrderStatusEntity getOrderStatusEntity() {
        return orderStatusEntity;
    }

    public void setOrderStatusEntity(OrderStatusEntity orderStatusEntity) {
        this.orderStatusEntity = orderStatusEntity;
    }

    @OneToOne
    @JoinColumn(name = "carId")
    @JsonManagedReference
    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }
}
