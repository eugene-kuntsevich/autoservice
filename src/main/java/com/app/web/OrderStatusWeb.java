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

import com.app.model.dto.OrderStatusDto;
import com.app.service.OrderStatusServiceImpl;
import com.app.service.api.OrderStatusService;

@RestController
@RequestMapping("/order_status")
public class OrderStatusWeb {
    private OrderStatusService orderStatusService;


    @GetMapping("/get-order-status-by-id/{id}")
    public OrderStatusDto findOrderStatusById(@PathVariable long id) {
        return orderStatusService.findOrderStatusById(id);
    }

    @PostMapping("/save-order-status")
    public void addOrderStatus(@RequestBody OrderStatusDto orderStatusDto) {
        orderStatusService.addOrderStatus(orderStatusDto);
    }

    @GetMapping("/find-all-order-status")
    public List<OrderStatusDto> findAllOrderStatus () {
        return orderStatusService.findAllOrderStatuses();
    }

    @DeleteMapping("/delete-order-status")
    public void deleteOrderStatus (@RequestBody OrderStatusDto orderStatusDto) {
        orderStatusService.deleteOrderStatus(orderStatusDto);
    }

    @Autowired
    public void setOrderStatus(OrderStatusServiceImpl orderStatusService) {
        this.orderStatusService = orderStatusService;
    }
}
