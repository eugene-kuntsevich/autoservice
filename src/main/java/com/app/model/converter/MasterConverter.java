package com.app.model.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.api.MasterDao;
import com.app.model.api.Converter;
import com.app.model.dto.MasterDto;
import com.app.model.dto.OrderDto;
import com.app.model.entity.MasterEntity;
import com.app.model.entity.OrderEntity;

@Component
public class MasterConverter implements Converter<MasterDto, MasterEntity> {

    private MasterDao masterDao;
    private OrderConverter orderConverter;

    @Override
    public MasterDto convertFromEntityToDto(MasterEntity entity) {
        MasterDto masterDto = new MasterDto();

        if (entity != null)
        {
            masterDto.setId(entity.getId());
            masterDto.setFirstName(entity.getFirstName() != null ? entity.getFirstName() : "");
            masterDto.setSecondName(entity.getSecondName() != null ? entity.getSecondName() : "");
            List<OrderDto> ordersDto = orderConverter.convertFromEntitiesToDtos(entity.getOrderEntity());
            masterDto.setOrdersDto(ordersDto);
        }

        return masterDto;
    }

    @Override
    public MasterEntity convertFromDtoToEntity(MasterDto dto) {
        Long id = dto.getId();
        MasterEntity masterEntity = ( id != null ) ? masterDao.getById(id) : new MasterEntity();

        masterEntity.setFirstName(dto.getFirstName());
        masterEntity.setSecondName(dto.getSecondName());

        List<OrderEntity> orderEntities = orderConverter.convertFromDtosToEntities(dto.getOrdersDto());
        masterEntity.setOrderEntity(orderEntities);

        return masterEntity;
    }

    @Autowired
    public void setMasterDao(MasterDao masterDao) {
        this.masterDao = masterDao;
    }

    @Autowired
    public void setOrderConverter(OrderConverter orderConverter) {
        this.orderConverter = orderConverter;
    }
}
