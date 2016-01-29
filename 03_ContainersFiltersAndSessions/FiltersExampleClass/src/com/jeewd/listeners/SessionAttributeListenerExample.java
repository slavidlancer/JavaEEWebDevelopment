package com.jeewd.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListenerExample implements
        HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println(event.getName() + " " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent arg0) {}

    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {}
}
