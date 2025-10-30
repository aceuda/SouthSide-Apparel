package com.southsideapparel.southsideapparel.repository;

import com.southsideapparel.southsideapparel.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
}
