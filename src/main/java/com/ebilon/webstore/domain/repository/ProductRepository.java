package com.ebilon.webstore.domain.repository;


import com.ebilon.webstore.domain.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(String productId);
    List<Product> getProductsByCategory(String category);
}
