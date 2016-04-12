package com.ebilon.webstore.domain.repository.impl;

import com.ebilon.webstore.domain.Customer;
import com.ebilon.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<>();

    public InMemoryCustomerRepository() {
        Customer customer = new Customer("1", "John", "Ukraine",3L);
        Customer customer1 = new Customer("2", "David", "Ukraine",5L);
        Customer customer2 = new Customer("3", "Eugene", "Ukraine",20L);

        listOfCustomers.add(customer);
        listOfCustomers.add(customer1);
        listOfCustomers.add(customer2);
    }
    public List<Customer> getAllCustomers(){
        return listOfCustomers;
    }
}
