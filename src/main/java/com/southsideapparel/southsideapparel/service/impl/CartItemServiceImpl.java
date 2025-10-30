package com.southsideapparel.southsideapparel.service.impl;

import com.southsideapparel.southsideapparel.model.CartItem;
import com.southsideapparel.southsideapparel.repository.CartItemRepository;
import com.southsideapparel.southsideapparel.service.CartItemService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository repo;

    public CartItemServiceImpl(CartItemRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<CartItem> getByCustomerId(Long customerId) {
        return repo.findByCustomerId(customerId);
    }

    @Override
    public CartItem addItem(CartItem item) {
        return repo.save(item);
    }

    @Override
    public CartItem updateQuantity(Long id, int quantity) {
        CartItem existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        existing.setQuantity(quantity);
        return repo.save(existing);
    }

    @Override
    public void removeItem(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void clearCart(Long customerId) {
        repo.deleteByCustomerId(customerId);
    }
}
