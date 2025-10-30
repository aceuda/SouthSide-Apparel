package com.southsideapparel.southsideapparel.service;

import com.southsideapparel.southsideapparel.model.Order;
import java.util.List;

public interface OrderService {
    List<Order> getAll();

    List<Order> getByCustomerId(Long customerId);

    Order getById(Long id);

    Order create(Order order);

    Order updateStatus(Long id, String status);

    void delete(Long id);
}
