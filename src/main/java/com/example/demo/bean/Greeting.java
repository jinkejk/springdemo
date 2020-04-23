package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author jinke
 * @date 16:40
 **/


public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
