package com.example.javaweb.dao;

import com.example.javaweb.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
}
