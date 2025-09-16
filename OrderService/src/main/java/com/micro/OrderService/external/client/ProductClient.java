package com.micro.OrderService.external.client;

import com.micro.OrderService.config.FeignConfig;
import com.micro.OrderService.model.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service",configuration = FeignConfig.class)
public interface ProductClient {

    @GetMapping("/products/{id}")
    Products getProductById(@PathVariable(name = "id") int id);


}
