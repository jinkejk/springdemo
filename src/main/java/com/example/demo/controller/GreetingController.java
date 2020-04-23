package com.example.demo.controller;

/**
 * @author jinke
 * @date 2020/01/16/16:44
 **/


import com.example.demo.bean.Greeting;
import com.example.demo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
//    @Autowired
//    private Person person;
    //不可以用于静态变量
    @Value("${person.name}")
    private String my_name;

    @GetMapping("/")
    public String greeting_str(@RequestParam(value = "name", defaultValue = "World") String name) {
        return my_name;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
