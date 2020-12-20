package com.app.web;

import com.app.model.dto.OrderStatusDto;
import com.app.model.entity.OrderStatusEntity;
import com.app.service.OrderStatusServiceImpl;
import com.app.service.api.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_status")
public class OrderStatusWeb {
    private OrderStatusService orderStatusService;


    @GetMapping("/get-order-status-by-id/{id}")
    public OrderStatusEntity findOrderStatusById(@PathVariable long id) {
        return orderStatusService.findOrderStatusById(id);
    }

    @PostMapping("/save-order-status")
    public void addOrderStatus(@RequestBody OrderStatusDto orderStatusDto) {
        orderStatusService.addOrderStatus(orderStatusDto);
    }

    @GetMapping("/find-all-order-status")
    public List<OrderStatusEntity> findAllOrderStatus () {
        return orderStatusService.findAllOrderStatus();
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
