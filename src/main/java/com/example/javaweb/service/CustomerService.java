package com.example.javaweb.service;

import com.example.javaweb.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    //findById
    Customer findByID(int id);

    //save
    Customer save(Customer customer);

    //deleteByID
    void deleteByID(int id);
}
