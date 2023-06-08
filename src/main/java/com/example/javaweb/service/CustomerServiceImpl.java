package com.example.javaweb.service;

import com.example.javaweb.dao.CustomerRepository;
import com.example.javaweb.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByID(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer customer1 = null;
        if(customer.isPresent()){
            customer1=customer.get();
        } else {
            throw new RuntimeException("Not found customer");
        }
        return customer1;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteByID(int id) {
        customerRepository.deleteById(id);
    }
}
