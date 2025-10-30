package com.southsideapparel.southsideapparel.repository;

import com.southsideapparel.southsideapparel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);

    List<Product> findByNameContainingIgnoreCase(String name);
}
