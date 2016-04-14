package com.ebilon.webstore.service;

import com.ebilon.webstore.domain.Cart;
public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
    Cart validate(String cartId);
}
