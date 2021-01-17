package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.api.GenericDao;
import com.app.model.api.PersistableEntity;

public abstract class AbstractDao<T extends PersistableEntity> implements GenericDao<T>
{
	protected EntityManager entityManager;
	private Class<T> clazz;

	public AbstractDao(Class<T> clazz)
	{
		this.clazz = clazz;
	}

	@Override
	public T getById(long id)
	{
		return entityManager.find(clazz, id);
	}

	@Override
	@Transactional
	public void delete(T entity)
	{
		if (entity.getId() != null)
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	@Override
	@Transactional
	public void saveOrUpdate(T entity)
	{
		if (entity.getId() != null)
		{
			entityManager.merge(entity);
		}
		else
		{
			entityManager.persist(entity);
		}
	}

	@Override
	public List<T> getAll()
	{
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(clazz);

		Root<T> entityRoot = criteriaQuery.from(clazz);

		criteriaQuery.select(entityRoot);

		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaDelete<T> criteriaDelete = builder.createCriteriaDelete(clazz);

		Root<T> root = criteriaDelete.from(clazz);
		criteriaDelete.where(builder.equal(root.get("id"), id));
		entityManager.createQuery(criteriaDelete).executeUpdate();
	}


	@Autowired
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
}
