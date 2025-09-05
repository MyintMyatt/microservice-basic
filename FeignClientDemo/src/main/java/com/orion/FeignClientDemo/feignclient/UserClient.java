package com.orion.FeignClientDemo.feignclient;

import com.orion.FeignClientDemo.model.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "user-client", url = "http://localhost:8081/users")
public interface UserClient {

    @GetMapping
    List<Users> getAllUser();

    @PostMapping
    Users register(@RequestBody Users users);

    @GetMapping("/{id}")
    Users getUserById(@PathVariable(name = "id") int id);

}
