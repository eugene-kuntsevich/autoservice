package com.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.dto.OrderDto;
import com.app.service.OrderServiceImpl;
import com.app.service.api.OrderService;

@RestController
@RequestMapping("/order")
public class OrderWeb {
    private OrderService orderService;

    @GetMapping("/get-order-by-id/{id}")
    public OrderDto findOrderById(@PathVariable long id) {
        return orderService.findOrderById(id);
    }

    @PostMapping("/save-order")
    public void addOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
    }

    @GetMapping("/find-all-order")
    public List<OrderDto> findAllOrder() {
        return orderService.findAllOrder();
    }

    @DeleteMapping("/delete-order")
    public void deleteOrder(@RequestBody OrderDto orderDto) {
        orderService.deleteOrder(orderDto);
    }

     @DeleteMapping("/delete-order/{id}")
    public void deleteOrder(@PathVariable long id) {
        orderService.deleteOrderById(id);
    }

    @Autowired
    public void setOrderStatus(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }
}
