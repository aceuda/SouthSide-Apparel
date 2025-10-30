package com.southsideapparel.southsideapparel.service.impl;

import com.southsideapparel.southsideapparel.model.Payment;
import com.southsideapparel.southsideapparel.repository.PaymentRepository;
import com.southsideapparel.southsideapparel.service.PaymentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repo;

    public PaymentServiceImpl(PaymentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Payment> getAll() {
        return repo.findAll();
    }

    @Override
    public Payment getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public Payment getByOrderId(Long orderId) {
        return repo.findByOrderId(orderId).orElse(null);
    }

    @Override
    public Payment create(Payment p) {
        return repo.save(p);
    }

    @Override
    public Payment updateStatus(Long id, String status) {
        Payment existing = getById(id);
        existing.setPaymentStatus(status);
        return repo.save(existing);
    }
}
