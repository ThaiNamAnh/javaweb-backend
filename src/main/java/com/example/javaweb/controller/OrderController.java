package com.example.javaweb.controller;

import com.example.javaweb.entity.Order;
import com.example.javaweb.entity.OrderItem;
import com.example.javaweb.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @CrossOrigin
    @GetMapping("/orders")
    public List<Order> findAll(){
        return orderService.findAll();
    }
    @CrossOrigin
    @GetMapping("/orders/{orderID}")
    public Order getOrderByID(@PathVariable int orderID){
        Order order = orderService.findByID(orderID);
        if(order == null) {
            throw new RuntimeException("Order not found");
        }
        return order;
    }
    @CrossOrigin
    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order){
        //merge: if id ==0 insert else update
        order.setId(0);
        return orderService.save(order);
    }
    @CrossOrigin
    @PutMapping("/orders")
    public Order updateOrder(@RequestBody Order order){
        return orderService.save(order);
    }
    @CrossOrigin
    @DeleteMapping("/orders/{orderID}")
    public String deleteOrder(@PathVariable int orderID){
        Order order = orderService.findByID(orderID);
        if(order == null){
            throw new RuntimeException("Not found order");
        }
        orderService.deleteByID(orderID);
        return "Delete order id " + orderID;
    }

    @GetMapping("/orders/{orderId}/orderItem")
    public Set<OrderItem> getOrderItemOfOrder(@PathVariable int orderId) {
        Order order = orderService.findByID(orderId);
        if (order != null) {
            Set<OrderItem> OrderItemOfOrder = order.getOrderItems();
            return OrderItemOfOrder;
        } else {
            throw new RuntimeException("Not found any OrderItem");
        }
    }
}
