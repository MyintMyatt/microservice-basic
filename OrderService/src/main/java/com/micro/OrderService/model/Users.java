package com.micro.OrderService.model;

import lombok.*;

@Data
@Builder
public class Users {
    private Integer id;
    private String email;
    private String name;
    private String gender;
}

