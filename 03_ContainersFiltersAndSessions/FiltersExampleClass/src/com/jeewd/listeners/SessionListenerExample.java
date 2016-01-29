package com.jeewd.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerExample implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        System.out.println("Session created. ID: " +
                sessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        
    }
}
