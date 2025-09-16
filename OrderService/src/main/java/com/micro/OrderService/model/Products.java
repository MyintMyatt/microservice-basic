package com.micro.OrderService.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Products {
    private Integer id;
    private String name;
    private double price;
}