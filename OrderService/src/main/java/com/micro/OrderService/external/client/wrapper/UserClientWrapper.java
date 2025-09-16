package com.micro.OrderService.external.client.wrapper;


import com.micro.OrderService.exception.CustomException;
import com.micro.OrderService.external.client.UserClient;
import com.micro.OrderService.model.Users;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserClientWrapper {

    @Autowired
    private UserClient userClient;

    @CircuitBreaker(name = "external-service", fallbackMethod = "userFallback")
    public Users getUserById(int userId) {
        return userClient.getUserById(userId);
    }

    public Users userFallback(int userId, Throwable e) {
        System.err.println("Executing userFallback for userId: " + userId + " due to: " + e.getMessage());
        throw new CustomException("User service is not available now.", "UNAVAILABLE", 503);
    }
}
