package com.app.service;

import com.app.dao.AbstractDao;
import com.app.dao.api.OrderDao;
import com.app.dao.impl.OrderDaoImpl;
import com.app.model.api.PersistableEntity;
import com.app.model.converter.OrderConverter;
import com.app.model.dto.OrderDto;
import com.app.model.dto.OrderStatusDto;
import com.app.model.entity.OrderEntity;
import com.app.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    private OrderConverter orderConverter;

    @Override
    public void saveOrder(OrderDto orderDto) throws Exception {
        OrderEntity orderEntity = orderConverter.convertFromDtoToEntity(orderDto);
        if (checkOrderStatus(orderDto)) {
            orderDao.saveOrUpdate(orderEntity);
        } else {
            throw new Exception();
        }
    }

    @Override
    public OrderDto findOrderById(long id) {
        OrderEntity orderEntity = orderDao.getById(id);
        return orderConverter.convertFromEntityToDto(orderEntity);
    }

    @Override
    public void deleteOrder(OrderDto orderDto) {
        OrderEntity orderEntity = orderConverter.convertFromDtoToEntity(orderDto);
        orderDao.delete(orderEntity);
    }

    @Override
    public void deleteOrderById(long orderId) {
        orderDao.deleteById(orderId);
    }

    @Override
    public List<OrderDto> findAllOrder() {
        List<OrderEntity> orderEntities = orderDao.getAll();
        return orderConverter.convertFromEntitiesToDtos(orderEntities);
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Autowired
    public void setOrderConverter(OrderConverter orderConverter) {
        this.orderConverter = orderConverter;
    }

    private boolean checkOrderStatus(OrderDto orderDto) {
        // Получаем список ордеров из бд
        List<OrderEntity> orderEntities = orderDao.getAll();
        if (orderEntities.size() > 0) {
            // Проверяем есть ли в бд объект с нужным нам id. Если есть достаём.
            // Если нет возвращаем true (создаём новый объект).
            OrderEntity orderEntity = null;
            for (OrderEntity order : orderEntities) {
                if (order.getId().equals(orderDto.getId())) {
                    orderEntity = order;
                } else {
                    return true;
                }
            }
            //Проверка вносимых в существующий ордер администратором данных  о машине и клиенте с уже
            // существующими данными (неуверен, что нужна)
            if (!(orderDto.getCarDto().equals(orderEntity.getCarEntity()) ||
                    !(orderDto.getClientDto().equals(orderEntity.getClientEntity())))) return false;

            long dtoId = orderDto.getOrderStatusDto().getId();
            long entityId = orderEntity.getOrderStatusEntity().getId();

            if (entityId == dtoId
                    || entityId == 1 && dtoId == 2
                    || entityId == 2 && dtoId == 3
                    || entityId == 2 && dtoId == 4
                    || entityId == 3 && dtoId == 2
                    || dtoId == 5) return true;
        } else {
            return false;
        }
        return false;
    }
}
