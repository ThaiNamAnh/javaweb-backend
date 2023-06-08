package com.example.javaweb.dao;

import com.example.javaweb.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
