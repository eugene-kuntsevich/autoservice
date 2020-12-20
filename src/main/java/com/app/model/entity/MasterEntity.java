package com.app.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "master")
public class MasterEntity extends PersistableEntityImpl {
    private String firstName;
    private String secondName;
    private Set<OrderEntity> orderEntities;

    @Column(name = "first_name", length = 20, nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "second_name", length = 20, nullable = false)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @ManyToMany(targetEntity = OrderEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "master_order",
            joinColumns = @JoinColumn(name = "master_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    @JsonBackReference
    public Set<OrderEntity> getOrderEntity() {
        return orderEntities;
    }

    public void setOrderEntity(Set<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }
}
