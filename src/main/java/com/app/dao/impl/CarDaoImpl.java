package com.app.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.app.dao.AbstractDao;
import com.app.dao.api.CarDao;
import com.app.model.entity.CarEntity;

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
}
