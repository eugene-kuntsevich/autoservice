package com.app.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.app.model.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import com.app.dao.AbstractDao;
import com.app.dao.api.CarDao;
import com.app.model.entity.CarEntity;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity> implements CarDao {

    public CarDaoImpl() {
        super(CarEntity.class);
    }

    @Override
    public CarEntity getCarByNumber(String number) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CarEntity> criteriaQuery = builder.createQuery(CarEntity.class);

        Root<CarEntity> entityRoot = criteriaQuery.from(CarEntity.class);
        criteriaQuery.select(entityRoot).where(builder.equal(entityRoot.get("carNumber"), number));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<CarEntity> getCarsEqualStatus(long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderEntity> orderCriteria = builder.createQuery(OrderEntity.class);

        Root<OrderEntity> rootOrder = orderCriteria.from(OrderEntity.class);
        orderCriteria.select(rootOrder).where(builder.equal(rootOrder.get("orderStatusEntity"), id));
        List<OrderEntity> list = entityManager.createQuery(orderCriteria).getResultList();

        List<Long> carsId = new ArrayList<>();
        for (OrderEntity orderEntity : list) {
            carsId.add(orderEntity.getCarEntity().getId());
        }

        CriteriaQuery<CarEntity> carCriteria = builder.createQuery(CarEntity.class);
        Root<CarEntity> rootCar = carCriteria.from(CarEntity.class);
        carCriteria.where(rootCar.get("id").in(carsId));

        return entityManager.createQuery(carCriteria).getResultList();
    }
}
