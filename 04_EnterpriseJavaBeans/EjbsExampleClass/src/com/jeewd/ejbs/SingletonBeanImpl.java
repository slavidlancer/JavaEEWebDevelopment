package com.jeewd.ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class SingletonBeanImpl implements SingletonBean {
    private int counter = 0;
    
    @Override
    public String singletonHelloWorld() {
        return "hello from singleton " + counter++;
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("singleton post construct");
    }
}
