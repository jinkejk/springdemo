package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Transactional
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id){
        User user = userRepository.getOne(id);
        System.out.println(user.getEmail());
        return user.toString();
    }

    @GetMapping("user/add")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }

    @GetMapping("user/test")
    public User testUser(){
        User user = new User();
        user.setEmail("jinke@aaa");
        user.setLastName("sdsad");
        return user;
    }
}
