package com.southsideapparel.southsideapparel.repository;

import com.southsideapparel.southsideapparel.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByOrderId(Long orderId);
}