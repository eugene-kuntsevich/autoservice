package com.app.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.app.dao.AbstractDao;
import com.app.dao.api.MasterDao;
import com.app.model.entity.MasterEntity;

@Repository
public class MasterDaoImpl extends AbstractDao<MasterEntity> implements MasterDao
{
	public MasterDaoImpl()
	{
		super(MasterEntity.class);
	}

	@Override
	public List<MasterEntity> getFreeMasters() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MasterEntity> criteriaQuery = criteriaBuilder.createQuery(MasterEntity.class);
		Root<MasterEntity> rootEntry = criteriaQuery.from(MasterEntity.class);

		CriteriaQuery<MasterEntity> free =
			criteriaQuery.select(rootEntry)
				.where(criteriaBuilder.isEmpty(rootEntry.get("orderEntities")));

		TypedQuery<MasterEntity> freeMastersQuery = entityManager.createQuery(free);

		return freeMastersQuery.getResultList();
	}
}
