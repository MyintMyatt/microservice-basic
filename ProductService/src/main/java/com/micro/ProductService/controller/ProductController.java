package com.micro.ProductService.controller;

import com.micro.ProductService.model.Products;
import com.micro.ProductService.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepo repo;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(repo.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Products obj) {
        return ResponseEntity.ok(repo.save(obj));
    }


}
