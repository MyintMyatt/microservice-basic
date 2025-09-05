package com.orion.FeignClientDemo.service;

import com.orion.FeignClientDemo.feignclient.UserClient;
import com.orion.FeignClientDemo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserClient userClient;

    public List<Users> getAllUser() {
        return userClient.getAllUser();
    }

    public Users register(Users user) {
        return userClient.register(user);
    }

    public Users getUserById(int id) {
        return userClient.getUserById(id);
    }
}
