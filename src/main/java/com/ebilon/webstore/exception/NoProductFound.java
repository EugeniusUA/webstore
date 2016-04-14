package com.ebilon.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No products found")
public class NoProductFound extends RuntimeException{
    private static final long serialVersionUID =-694354952032299587L;
    private String productId;
    public NoProductFound(String productId) {
        this.productId = productId;
    }
    public String getProductId() {
        return productId;
    }
}
