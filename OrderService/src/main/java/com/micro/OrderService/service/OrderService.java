package com.micro.OrderService.service;

import com.micro.OrderService.external.client.ProductClient;
import com.micro.OrderService.external.client.UserClient;
import com.micro.OrderService.external.client.wrapper.ProductClientWrapper;
import com.micro.OrderService.external.client.wrapper.UserClientWrapper;
import com.micro.OrderService.model.Orders;
import com.micro.OrderService.model.Products;
import com.micro.OrderService.model.Users;
import com.micro.OrderService.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderRepo repo;

    @Autowired
    private UserClientWrapper userClientWrapper;

    @Autowired
    private ProductClientWrapper productClientWrapper;


    public Orders order(Orders orders) {
        // Now calling the method on the proxied bean
        Users user = userClientWrapper.getUserById(orders.getUser_id());
        Products products = productClientWrapper.getProductById(orders.getProduct_id());
        // You might want to remove the null check since the fallback will throw an exception
        if (user == null) throw new RuntimeException("User Not found.");
        if (products == null) throw new RuntimeException("Product Not found.");
        return repo.save(orders);
    }

//    @CircuitBreaker(name = "external-service", fallbackMethod = "productFallback")
//    public Products getProductById(int productId) {
//        System.out.println("Calling getProductById with id=" + productId);
//        try {
//            return productClient.getProductById(productId);
//        } catch (FeignException e) {
//            throw e; // propagate to circuit breaker
//        }
//    }

//    @CircuitBreaker(name = "external-service", fallbackMethod = "userFallback")
//    public Users getUserById(int userId) {
//        return userClient.getUserById(userId);
//    }

//    public Products productFallback(int productId, Throwable e) {
//        System.err.println("product fallback");
//        throw new CustomException("Product service is not available now.\n" + e.getMessage(), "UNAVAILABLE", 500);
//    }
//
//    public Users userFallback(int userId, Throwable e) {
//        throw new CustomException("User service is not available now.\n", "UNAVAILABLE", 500);
//    }

    public List<Orders> getAllOrder() {
        return repo.findAll();
    }
}
