package com.example.javaweb.dao;

import com.example.javaweb.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
