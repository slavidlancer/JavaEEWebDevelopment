package com.jeewd.beans;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldImpl implements HelloWorld {
    public String sayHello() {
        return "hello";
    }
}
