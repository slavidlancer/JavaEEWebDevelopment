package com.jeewd.ejbs;

import javax.ejb.Stateless;

@Stateless
public class StatelessHelloWorldImpl2 implements StatelessHelloWorld {
    @Override
    public String helloStatelessEjb() {
        return "new implementation";
    }
}
