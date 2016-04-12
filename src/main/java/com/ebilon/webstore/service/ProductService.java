package com.ebilon.webstore.service;

import com.ebilon.webstore.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
}
