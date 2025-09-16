package com.micro.OrderService.external.client;

import com.micro.OrderService.config.FeignConfig;
import com.micro.OrderService.model.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping("/users/{id}")
    Users getUserById(@PathVariable(name = "id") int id);

}
