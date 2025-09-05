package com.orion.FeignClientDemo.controller;

import com.orion.FeignClientDemo.model.Users;
import com.orion.FeignClientDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAllUser());
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody Users user) {
        System.out.println(user);
        return ResponseEntity.ok(service.register(user));
    }


}
