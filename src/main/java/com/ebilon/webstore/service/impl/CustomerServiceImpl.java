package com.ebilon.webstore.service.impl;

import com.ebilon.webstore.domain.Customer;
import com.ebilon.webstore.domain.repository.CustomerRepository;
import com.ebilon.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
