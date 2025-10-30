package com.southsideapparel.southsideapparel.service;

import com.southsideapparel.southsideapparel.model.OrderItem;
import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAll();

    List<OrderItem> getByOrderId(Long orderId);

    OrderItem getById(Long id);

    OrderItem create(OrderItem item);

    void delete(Long id);
}
