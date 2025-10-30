package com.southsideapparel.southsideapparel.controller;

import com.southsideapparel.southsideapparel.model.Order;
import com.southsideapparel.southsideapparel.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> all() {
        return service.getAll();
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> byCustomer(@PathVariable Long customerId) {
        return service.getByCustomerId(customerId);
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id, @RequestBody String status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
