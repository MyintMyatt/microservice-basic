package com.micro.OrderService.external.client.wrapper;

import com.micro.OrderService.exception.CustomException;
import com.micro.OrderService.external.client.ProductClient;
import com.micro.OrderService.external.client.UserClient;
import com.micro.OrderService.model.Products;
import com.micro.OrderService.model.Users;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductClientWrapper {
    @Autowired
    private ProductClient productClient;

    @CircuitBreaker(name = "external-service", fallbackMethod = "productFallback")
    public Products getProductById(int prodId) {
        return productClient.getProductById(prodId);
    }

    public Products productFallback(int productId, Throwable e) {
        throw new CustomException("Product service is not available now.\n" + e.getMessage(), "UNAVAILABLE", 500);
    }
}
