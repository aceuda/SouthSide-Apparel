package com.southsideapparel.southsideapparel.service;

import com.southsideapparel.southsideapparel.model.Payment;
import java.util.List;

public interface PaymentService {
    List<Payment> getAll();

    Payment getById(Long id);

    Payment getByOrderId(Long orderId);

    Payment create(Payment payment);

    Payment updateStatus(Long id, String status);
}
