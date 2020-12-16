package com.app.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car")
public class CarEntity extends PersistableEntityImpl {
    private String carNumber;
    private Date warrantyDate;
    private OrderEntity orderEntity;

    @Column(name = "car_number", length = 300)
    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Column(name = "warranty_date", length = 300)
    public Date getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(Date warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

    @OneToOne
    @JoinColumn(name = "orderId")
    @JsonManagedReference
    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
