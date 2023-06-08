package com.example.javaweb.service;

import com.example.javaweb.dao.OrderItemRepository;
import com.example.javaweb.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    private OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem findByID(int id) {
        Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        OrderItem orderItem1 = null;
        if(orderItem.isPresent()){
            orderItem1=orderItem.get();
        } else {
            throw new RuntimeException("Not found orderitem");
        }
        return orderItem1;
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteByID(int id) {
        orderItemRepository.deleteById(id);
    }
}
