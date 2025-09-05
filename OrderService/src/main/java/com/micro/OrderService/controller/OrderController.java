package com.micro.OrderService.controller;


import com.micro.OrderService.model.Orders;
import com.micro.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> order(@RequestBody Orders obj) {
        return ResponseEntity.ok(orderService.order(obj));
    }

    @GetMapping
    public ResponseEntity<?> getAllOrder() {
        return ResponseEntity.ok(orderService.getAllOrder());
    }


}
