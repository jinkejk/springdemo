package com.example.demo.controller;

import com.example.demo.exception.MyTestException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jinke
 * @date 2020/04/25/17:35
 **/

@ControllerAdvice
public class MyExceptionHandler {

    // 无法自适应
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public Map<String, Object> handleException(Exception e){
//        Map<String, Object> map = new HashMap<>();
//        map.put("result", true);
//        map.put("message", "error 121212312");
//        return map;
//    }

    //自适应
    @ExceptionHandler(MyTestException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();

        //触发框架跳转到 404 页面
        request.setAttribute("javax.servlet.error.status_code", 404);
        map.put("result", true);
        map.put("message", e.getMessage());
        return "forward:/error";
    }
}
