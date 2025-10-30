package com.southsideapparel.southsideapparel.service.impl;

import com.southsideapparel.southsideapparel.model.Product;
import com.southsideapparel.southsideapparel.repository.ProductRepository;
import com.southsideapparel.southsideapparel.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Product getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product create(Product product) {
        return repo.save(product);
    }

    @Override
    public Product update(Long id, Product p) {
        Product existing = getById(id);
        existing.setName(p.getName());
        existing.setCategory(p.getCategory());
        existing.setDescription(p.getDescription());
        existing.setPrice(p.getPrice());
        existing.setImageUrl(p.getImageUrl());
        existing.setStockQuantity(p.getStockQuantity());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
