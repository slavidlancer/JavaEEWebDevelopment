package com.jeewd.listeners;

import java.util.Date;
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

    @SuppressWarnings("deprecation")
    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        System.out.println("Session destroyed at " +
                new Date().toLocaleString() + ". ID: " +
                sessionEvent.getSession().getId());
    }
}
