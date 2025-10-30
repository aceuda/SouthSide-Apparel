package com.southsideapparel.southsideapparel.controller;

import com.southsideapparel.southsideapparel.model.CartItem;
import com.southsideapparel.southsideapparel.service.CartItemService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartItemController {

    private final CartItemService service;

    public CartItemController(CartItemService service) {
        this.service = service;
    }

    @GetMapping("/{customerId}")
    public List<CartItem> getCart(@PathVariable Long customerId) {
        return service.getByCustomerId(customerId);
    }

    @PostMapping
    public CartItem add(@RequestBody CartItem item) {
        return service.addItem(item);
    }

    @PutMapping("/{id}/quantity")
    public CartItem updateQuantity(@PathVariable Long id, @RequestBody int quantity) {
        return service.updateQuantity(id, quantity);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        service.removeItem(id);
    }

    @DeleteMapping("/clear/{customerId}")
    public void clear(@PathVariable Long customerId) {
        service.clearCart(customerId);
    }
}
