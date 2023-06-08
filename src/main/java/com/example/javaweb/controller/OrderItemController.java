package com.example.javaweb.controller;

import com.example.javaweb.entity.OrderItem;
import com.example.javaweb.service.OrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderItemController {
    private OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @CrossOrigin
    @GetMapping("/orderItems")
    public List<OrderItem> findAll(){
        return orderItemService.findAll();
    }
    @CrossOrigin
    @GetMapping("/orderItems/{orderItemID}")
    public OrderItem getEmployeeByID(@PathVariable int orderItemID){
        OrderItem orderItem = orderItemService.findByID(orderItemID);
        if(orderItem == null) {
            throw new RuntimeException("orderItemID not found");
        }
        return orderItem;
    }
    @CrossOrigin
    @PostMapping("/orderItems")
    public OrderItem addorderItem(@RequestBody OrderItem orderItem){
        //merge: if id ==0 insert else update
        orderItem.setId(0);
        return orderItemService.save(orderItem);
    }
    @CrossOrigin
    @PutMapping("/orderItems")
    public OrderItem updateOrderItem(@RequestBody OrderItem orderItem){
        return orderItemService.save(orderItem);
    }
    @CrossOrigin
    @DeleteMapping("/orderItems/{orderItemID}")
    public String deleteOrderItem(@PathVariable int orderItemID){
        OrderItem orderItem = orderItemService.findByID(orderItemID);
        if(orderItem == null){
            throw new RuntimeException("Not found orderItem");
        }
        orderItemService.deleteByID(orderItemID);
        return "Delete orderItem id " + orderItemID;
    }
}
