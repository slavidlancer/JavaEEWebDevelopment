package com.jeewd.ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

@Stateful
public class StatefulHelloWorldImpl implements StatefulHelloWorld {
    private int counter = 0;
    
    @Override
    public String statefulHelloWorld() {
        return "hello from stateful EJB " + counter++;
    }
    
    @PrePassivate
    public void beforePassivate() {
        System.out.println("stateful before passivate");
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("stateful post construct");
    }
}
