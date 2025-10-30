package com.southsideapparel.southsideapparel.controller;

import com.southsideapparel.southsideapparel.model.Customer;
import com.southsideapparel.southsideapparel.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        return service.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
