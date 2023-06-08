package com.example.javaweb.service;

import com.example.javaweb.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> findAll();

    //findById
    OrderItem findByID(int id);

    //save
    OrderItem save(OrderItem orderItem);

    //deleteByID
    void deleteByID(int id);
}
