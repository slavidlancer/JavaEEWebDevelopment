package com.jeewd.ejbs;

import javax.ejb.Local;

@Local
public interface StatefulHelloWorld {
    String statefulHelloWorld();
}
