package com.example.demo.controller;

/**
 * @author jinke
 * @date 2020/01/16/16:44
 **/


import com.example.demo.bean.Greeting;
import com.example.demo.exception.MyTestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
//    @Autowired
//    private Person person;

    //不可以用于静态变量
    @Value("${person.name}")
    private String my_name;

    @ResponseBody
    @GetMapping("/")
    public String greeting_str(@RequestParam(value = "name", defaultValue = "World") String name) {
        return my_name;
    }

    @ResponseBody
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        if (name.equals("jinke")){
            throw new MyTestException();
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/success")
    public ModelAndView success(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("test", "jinke");


        return modelAndView ;
    }
}
