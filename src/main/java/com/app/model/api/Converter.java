package com.app.model.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface Converter<D extends Dto, E extends PersistableEntity> {
	D convertFromEntityToDto(E entity);

	E convertFromDtoToEntity(D dto);

	default List<E> convertFromDtosToEntities(List<D> dtos) {
		if (dtos != null) {
			return dtos.stream().map(this::convertFromDtoToEntity).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	default List<D> convertFromEntitiesToDtos(List<E> entities) {
		if (entities != null) {
			return entities.stream().map(this::convertFromEntityToDto).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}
}
