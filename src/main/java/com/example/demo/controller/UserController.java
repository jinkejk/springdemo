package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Transactional
    @GetMapping("/{id}")
    public User getUser(@PathVariable(value = "id") Integer id){
        User user = userRepository.getOne(id);
        System.out.println(user.getEmail());
        return user;
    }

    @GetMapping(value = "/add", params = {"lastName", "email"})
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }

    @PostMapping("/test")
    public String testUser(@RequestBody String body){
        System.out.println(body);
        return body;
    }
}
