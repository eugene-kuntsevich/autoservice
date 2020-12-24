package com.app.dao.api;

import java.util.List;

import com.app.model.api.PersistableEntity;

public interface GenericDao<T extends PersistableEntity> {
	T getById(long id);

	void delete(T entity);

	void saveOrUpdate(T entity);

	List<T> getAll();

	void deleteById(long id);
}
