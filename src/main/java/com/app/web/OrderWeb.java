package com.app.web;

import com.app.model.dto.OrderDto;
import com.app.model.entity.OrderEntity;
import com.app.service.OrderServiceImpl;
import com.app.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderWeb {
    private OrderService orderService;

    @GetMapping("/get-order-by-id/{id}")
    public OrderEntity findOrderById(@PathVariable long id) {
        return orderService.findOrderById(id);
    }

    @PostMapping("/save-order")
    public void addOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
    }

    @GetMapping("/find-all-order")
    public List<OrderEntity> findAllOrder() {
        return orderService.findAllOrder();
    }

    @DeleteMapping("/delete-order")
    public void deleteOrder(@RequestBody OrderDto orderDto) {
        orderService.deleteOrder(orderDto);
    }

    @Autowired
    public void setOrderStatus(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }
}
