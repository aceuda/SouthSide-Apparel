package com.southsideapparel.southsideapparel.service.impl;

import com.southsideapparel.southsideapparel.model.OrderItem;
import com.southsideapparel.southsideapparel.repository.OrderItemRepository;
import com.southsideapparel.southsideapparel.service.OrderItemService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository repo;

    public OrderItemServiceImpl(OrderItemRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<OrderItem> getAll() {
        return repo.findAll();
    }

    @Override
    public List<OrderItem> getByOrderId(Long orderId) {
        return repo.findByOrderId(orderId);
    }

    @Override
    public OrderItem getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Order item not found"));
    }

    @Override
    public OrderItem create(OrderItem item) {
        return repo.save(item);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
