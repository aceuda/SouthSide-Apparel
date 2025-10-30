package com.southsideapparel.southsideapparel.repository;

import com.southsideapparel.southsideapparel.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCustomerId(Long customerId);

    void deleteByCustomerId(Long customerId);
}
