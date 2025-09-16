package com.micro.ProductService.controller;

import com.micro.ProductService.model.Products;
import com.micro.ProductService.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepo repo;

    @Value("${app.message}") // Injected from config-server
    private String message;

    @GetMapping("/msg")
    public String getMessage() {
        return message;
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(name = "id") int id) {
        return ResponseEntity.status(500).body("No responding");
//        return ResponseEntity.ok(repo.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Products obj) {
        return ResponseEntity.ok(repo.save(obj));
    }


}
