package com.ebilon.webstore.service.impl;

import com.ebilon.webstore.domain.Product;
import com.ebilon.webstore.domain.repository.ProductRepository;
import com.ebilon.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    @Override
    public Product getProductById(String productId) {
       return productRepository.getProductById(productId);
    }

    @Override
    public List<Product> getProductsByManufacturer(String category,Map<String, List<String>> priceParams,String manufacturer) {
        return productRepository.getProductsByPriceRangeAndManufacturer(category,priceParams,manufacturer);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
