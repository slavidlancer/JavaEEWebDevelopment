package com.jeewd.ejbs;

import javax.ejb.Stateless;

@Stateless
public class StatelessHelloWorldImpl implements StatelessHelloWorld {
    private int counter = 0;
    
    @Override
    public String helloStatelessEjb() {
        return "hello from statless EJB " + counter++;
    }
}
