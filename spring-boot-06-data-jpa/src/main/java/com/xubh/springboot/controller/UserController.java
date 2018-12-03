package com.xubh.springboot.controller;

import com.xubh.springboot.entity.Users;
import com.xubh.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable("id") Integer id){
        Users user = userRepository.findOne(id);
        return user;
    }

    @GetMapping("/user")
    public Users insertUser(Users user){
        Users save = userRepository.save(user);
        return save;
    }

}
