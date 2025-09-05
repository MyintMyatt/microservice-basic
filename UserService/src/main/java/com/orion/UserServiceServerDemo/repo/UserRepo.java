package com.orion.UserServiceServerDemo.repo;

import com.orion.UserServiceServerDemo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
}
