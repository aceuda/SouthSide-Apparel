package com.southsideapparel.southsideapparel.service;

import com.southsideapparel.southsideapparel.model.CartItem;
import java.util.List;

public interface CartItemService {
    List<CartItem> getByCustomerId(Long customerId);

    CartItem addItem(CartItem item);

    CartItem updateQuantity(Long id, int quantity);

    void removeItem(Long id);

    void clearCart(Long customerId);
}
