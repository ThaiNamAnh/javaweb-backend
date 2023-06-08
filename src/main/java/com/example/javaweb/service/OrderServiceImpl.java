package com.example.javaweb.service;

import com.example.javaweb.dao.OrderRepository;
import com.example.javaweb.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findByID(int id) {
        Optional<Order> order = orderRepository.findById(id);
        Order order1 = null;
        if(order.isPresent()){
            order1=order.get();
        } else {
            throw new RuntimeException("Not found order");
        }
        return order1;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteByID(int id) {
        orderRepository.deleteById(id);
    }
}
