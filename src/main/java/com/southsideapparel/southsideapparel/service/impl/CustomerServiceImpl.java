package com.southsideapparel.southsideapparel.service.impl;

import com.southsideapparel.southsideapparel.model.Customer;
import com.southsideapparel.southsideapparel.repository.CustomerRepository;
import com.southsideapparel.southsideapparel.service.CustomerService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;

    public CustomerServiceImpl(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Customer> getAll() {
        return repo.findAll();
    }

    @Override
    public Customer getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public Customer create(Customer c) {
        return repo.save(c);
    }

    @Override
    public Customer update(Long id, Customer c) {
        Customer existing = getById(id);
        existing.setFirstName(c.getFirstName());
        existing.setLastName(c.getLastName());
        existing.setEmail(c.getEmail());
        existing.setPhone(c.getPhone());
        existing.setAddressLine1(c.getAddressLine1());
        existing.setAddressLine2(c.getAddressLine2());
        existing.setCity(c.getCity());
        existing.setProvince(c.getProvince());
        existing.setPostalCode(c.getPostalCode());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
