package com.southsideapparel.southsideapparel.service.impl;

import com.southsideapparel.southsideapparel.model.Order;
import com.southsideapparel.southsideapparel.repository.OrderRepository;
import com.southsideapparel.southsideapparel.service.OrderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repo;

    public OrderServiceImpl(OrderRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Order> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Order> getByCustomerId(Long customerId) {
        return repo.findByCustomerId(customerId);
    }

    @Override
    public Order getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order create(Order order) {
        return repo.save(order);
    }

    @Override
    public Order updateStatus(Long id, String status) {
        Order existing = getById(id);
        existing.setOrderStatus(status);
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
