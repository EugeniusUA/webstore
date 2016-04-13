package com.ebilon.webstore.domain.repository.impl;

import com.ebilon.webstore.domain.Product;
import com.ebilon.webstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<>();

    public InMemoryProductRepository() {
        Product iphone = new Product("P123", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
        iphone.setCategory("Smart Phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(3);
        Product laptop_dell = new Product("P125", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
                laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(3);
        Product tablet_Nexus = new Product("P126", "Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad - core Qualcomm Snapdragon™ S4 Pro processor");
                tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(3);
        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }
    public List<Product> getAllProducts(){
        return listOfProducts;
    }


    public Product getProductById(String productId){
        Product productById = null;
        for (Product product: listOfProducts){
            if (product != null && product.getProductId() != null &&
                    product.getProductId().equals(productId)){
                productById = product;
                break;
            }
        }
    if (productById == null){
        throw new IllegalArgumentException("No prodcts found with the product id: "+productId);
    }
        return productById;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product: listOfProducts){
            if (category.equalsIgnoreCase(product.getCategory())){
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }
    public Set<Product> getProductsByFilter(Map<String, List<String>>
                                                    filterParams) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        Set<String> criterias = filterParams.keySet();
        if(criterias.contains("brand")) {
            for(String brandName: filterParams.get("brand")) {
                for(Product product: listOfProducts) {
                    if(brandName.equalsIgnoreCase(product.getManufacturer())){
                        productsByBrand.add(product);
                    }
                }
            }
        }
        if(criterias.contains("category")) {
            for(String category: filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
        }
        return productsByBrand;
    }

    @Override
    public List<Product> getProductsByPriceRangeAndManufacturer(String category,Map<String, List<String>> priceParams,String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<>();
        for (Product product: listOfProducts){
            if (manufacturer.equalsIgnoreCase(product.getManufacturer())){
                productsByManufacturer.add(product);
            }
        }
        productsByManufacturer.retainAll(getProductByPriceRange(priceParams));
        productsByManufacturer.retainAll(getProductsByCategory(category));
        return productsByManufacturer;
    }

    @Override
    public Set<Product> getProductByPriceRange(Map<String, List<String>> priceParams) {
        Set<Product> productsByPriceRange = new HashSet<>();
        Set<String> priceCriteria = priceParams.keySet();
        BigDecimal highPrice = null;
        BigDecimal lowPrice = null;
        if(priceCriteria.contains("high")) {
            for (String high : priceParams.get("high")) {
                highPrice = new BigDecimal(high);
            }
        }
        if(priceCriteria.contains("low")) {
            for (String low : priceParams.get("low")) {
                lowPrice = new BigDecimal(low);
            }
        }
        if (lowPrice != null && highPrice != null) {
            for (Product product : listOfProducts) {
                double unitPrice = product.getUnitPrice().doubleValue();
                if (unitPrice >= lowPrice.doubleValue() &&
                        unitPrice <= highPrice.doubleValue()) {
                    productsByPriceRange.add(product);
                }
            }
        }
        return productsByPriceRange;
    }
}
