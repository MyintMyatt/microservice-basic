package com.micro.OrderService.service;

import com.micro.OrderService.feignclient.ProductClient;
import com.micro.OrderService.feignclient.UserClient;
import com.micro.OrderService.model.Orders;
import com.micro.OrderService.model.Products;
import com.micro.OrderService.model.Users;
import com.micro.OrderService.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
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


    public Orders order(Orders orders) {

        Users user = userClient.getUserById(orders.getUser_id());
        if (user == null) {
            throw  new RuntimeException("User Not found.");
        }

        Products product = productClient.getProductById(orders.getProduct_id());
        if (product == null) {
            throw new RuntimeException("Product Not found.");
        }

       return repo.save(orders);
    }

    public List<Orders> getAllOrder() {
        return repo.findAll();
    }
}
