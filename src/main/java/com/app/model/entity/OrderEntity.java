package com.app.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "`order`")
public class OrderEntity extends PersistableEntityImpl {

    private ClientEntity clientEntity;
    private OrderStatusEntity orderStatusEntity;
    private CarEntity carEntity;
    private List<MasterEntity> masterEntity;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "client_id")
    @JsonManagedReference
    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "status_id")
    @JsonManagedReference
    public OrderStatusEntity getOrderStatusEntity() {
        return orderStatusEntity;
    }

    public void setOrderStatusEntity(OrderStatusEntity orderStatusEntity) {
        this.orderStatusEntity = orderStatusEntity;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "car_id")
    @JsonManagedReference
    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }

    @ManyToMany(targetEntity = MasterEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "master_order",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "master_id")})
    @JsonManagedReference
    public List<MasterEntity> getMasterEntity() {
        return masterEntity;
    }

    public void setMasterEntity(List<MasterEntity> masterEntity) {
        this.masterEntity = masterEntity;
    }
}
