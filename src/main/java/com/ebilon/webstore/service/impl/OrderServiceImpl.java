package com.ebilon.webstore.service.impl;

import com.ebilon.webstore.domain.Order;
import com.ebilon.webstore.domain.Product;
import com.ebilon.webstore.domain.repository.OrderRepository;
import com.ebilon.webstore.domain.repository.ProductRepository;
import com.ebilon.webstore.service.CartService;
import com.ebilon.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartService cartService;

    public void processOrder(String productId, int quantity){
        Product productById = productRepository.getProductById(productId);
        if (productById.getUnitsInStock() < quantity){
            throw new IllegalArgumentException("Out of stock. Available units in stock " + productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
    }
    public Long saveOrder(Order order) {
        Long orderId = orderRepository.saveOrder(order);
        cartService.delete(order.getCart().getCartId());
        return orderId;
    }
}
