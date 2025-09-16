package com.orion.UserServiceServerDemo.controller;

import com.orion.UserServiceServerDemo.model.Users;
import com.orion.UserServiceServerDemo.repo.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Value("${app.message}")
    private String message;

    @GetMapping("/msg")
    public String getMessage() {
        return message;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(
            @PathVariable(name = "id") int id
    ) throws InterruptedException {
//        Thread.sleep(50000);
        return ResponseEntity.ok(userRepo.findById(id));
    }


    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody Users user) {
        System.out.println(user);
        return ResponseEntity.ok(userRepo.save(user));
    }


}
