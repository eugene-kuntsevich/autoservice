package com.app.dao.api;

import java.util.List;

import com.app.model.entity.PersistableEntity;

public interface GenericDao<T extends PersistableEntity> extends PersistableEntity
{
	T get(long id);

	void delete(T entity);

	void saveOrUpdate(T entity);

	List<T> list();
}
