package com.app.model.converter;

import java.util.List;
import java.util.stream.Collectors;

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
    private CarConverter carConverter;
    private ClientConverter clientConverter;
    private OrderStatusConverter orderStatusConverter;

    @Override
    public MasterDto convertFromEntityToDto(MasterEntity entity) {
        MasterDto masterDto = new MasterDto();

        if (entity != null) {
            masterDto.setId(entity.getId());
            masterDto.setFirstName(entity.getFirstName() != null ? entity.getFirstName() : "");
            masterDto.setSecondName(entity.getSecondName() != null ? entity.getSecondName() : "");
//            masterDto.setAmountOfOrders(entity.getOrderEntities().size());
//            List<OrderEntity> orderEntities = entity.getOrderEntities();
//            List<OrderDto> ordersDtos = orderEntities.stream().map(orderEntity -> {
//                OrderDto orderDto = new OrderDto();
//                orderDto.setCarDto(carConverter.convertFromEntityToDto(orderEntity.getCarEntity()));
//                orderDto.setClientDto(clientConverter.convertFromEntityToDto(orderEntity.getClientEntity()));
//                orderDto.setOrderStatusDto(orderStatusConverter.convertFromEntityToDto(orderEntity.getOrderStatusEntity()));
//                return orderDto;
//            }).collect(Collectors.toList());
//            masterDto.setOrdersDto(ordersDtos);
        }

        return masterDto;
    }

    @Override
    public MasterEntity convertFromDtoToEntity(MasterDto dto) {
        Long id = dto.getId();
        MasterEntity masterEntity;
        if (id != null) {
            masterEntity = (masterDao.getById(id) != null) ? masterDao.getById(id) : new MasterEntity() ;
        } else {
            masterEntity = new MasterEntity();
        }

        masterEntity.setFirstName(dto.getFirstName());
        masterEntity.setSecondName(dto.getSecondName());

        List<OrderEntity> orderEntities = orderConverter.convertFromDtosToEntities(dto.getOrdersDto());
        masterEntity.setOrderEntities(orderEntities);

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

    @Autowired
    public void setCarConverter(CarConverter carConverter) {
        this.carConverter = carConverter;
    }

    @Autowired
    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }

    @Autowired
    public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter) {
        this.orderStatusConverter = orderStatusConverter;
    }
}
