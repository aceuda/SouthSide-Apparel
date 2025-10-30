package com.southsideapparel.southsideapparel.service;

import com.southsideapparel.southsideapparel.model.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    Customer getById(Long id);

    Customer create(Customer customer);

    Customer update(Long id, Customer customer);

    void delete(Long id);
}
