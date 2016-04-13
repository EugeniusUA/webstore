package com.ebilon.webstore.service;

import com.ebilon.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    Product getProductById(String productId);
    List <Product> getProductsByManufacturer(String category, Map<String, List<String>> priceParams,String manufacturer);
}
