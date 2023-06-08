package com.example.javaweb.service;

import com.example.javaweb.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    //findById
    Order findByID(int id);

    //save
    Order save(Order order);

    //deleteByID
    void deleteByID(int id);
}
