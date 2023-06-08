package com.example.javaweb.controller;

import com.example.javaweb.entity.Customer;
import com.example.javaweb.entity.Order;
import com.example.javaweb.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @CrossOrigin
    @GetMapping("/customers")
    public List<Customer> findAll(){
        return customerService.findAll();
    }
    @CrossOrigin
    @GetMapping("/customers/{customerID}")
    public Customer getCustomerByID(@PathVariable int customerID){
        Customer customer = customerService.findByID(customerID);
        if(customer == null) {
            throw new RuntimeException("Customer not found");
        }
        return customer;
    }
    @CrossOrigin
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        //merge: if id ==0 insert else update
        customer.setId(0);
        return customerService.save(customer);
    }
    @CrossOrigin
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.save(customer);
    }
    @CrossOrigin
    @DeleteMapping("/customers/{customerID}")
    public String deleteCustomer(@PathVariable int customerID){
        Customer customer = customerService.findByID(customerID);
        if(customer == null){
            throw new RuntimeException("Not found customer");
        }
        customerService.deleteByID(customerID);
        return "Delete customer ID " + customerID;
    }

    @GetMapping("/customers/{customerId}/orders")
    public Set<Order> getCustomerOrders(@PathVariable int customerId) {
        Customer customer = customerService.findByID(customerId);
        if (customer != null) {
            Set<Order> customerOrders = customer.getOrders();
            return customerOrders;
        } else {
            return null;
        }
    }
}
