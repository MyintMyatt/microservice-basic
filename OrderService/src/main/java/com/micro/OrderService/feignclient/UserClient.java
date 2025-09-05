package com.micro.OrderService.feignclient;

import com.micro.OrderService.model.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/users/{id}")
    Users getUserById(@PathVariable(name = "id") int id);

}
