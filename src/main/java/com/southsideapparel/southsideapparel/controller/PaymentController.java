package com.southsideapparel.southsideapparel.controller;

import com.southsideapparel.southsideapparel.model.Payment;
import com.southsideapparel.southsideapparel.service.PaymentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Payment> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Payment get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/order/{orderId}")
    public Payment getByOrder(@PathVariable Long orderId) {
        return service.getByOrderId(orderId);
    }

    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        return service.create(payment);
    }

    @PutMapping("/{id}/status")
    public Payment updateStatus(@PathVariable Long id, @RequestBody String status) {
        return service.updateStatus(id, status);
    }
}
