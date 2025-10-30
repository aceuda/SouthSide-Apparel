package com.southsideapparel.southsideapparel.controller;

import com.southsideapparel.southsideapparel.model.OrderItem;
import com.southsideapparel.southsideapparel.service.OrderItemService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderItemController {

    private final OrderItemService service;

    public OrderItemController(OrderItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrderItem> all() {
        return service.getAll();
    }

    @GetMapping("/order/{orderId}")
    public List<OrderItem> byOrder(@PathVariable Long orderId) {
        return service.getByOrderId(orderId);
    }

    @GetMapping("/{id}")
    public OrderItem get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public OrderItem create(@RequestBody OrderItem item) {
        return service.create(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
