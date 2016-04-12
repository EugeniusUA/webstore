package com.ebilon.webstore.domain.repository;


import com.ebilon.webstore.domain.Product;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(String productId);
    List<Product> getProductsByCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>>
                                             filterParams);
    List <Product> getProductsByPriceRangeAndManufacturer(Map<String, List<String>> priceParams,String manufacturer);
    Set<Product> getProductByPriceRange(Map<String, List<String>> priceParams);
}
