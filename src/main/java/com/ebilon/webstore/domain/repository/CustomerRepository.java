package com.ebilon.webstore.domain.repository;

import com.ebilon.webstore.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
}
