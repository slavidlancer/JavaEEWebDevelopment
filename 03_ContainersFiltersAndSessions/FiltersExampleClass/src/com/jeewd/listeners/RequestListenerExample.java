package com.jeewd.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListenerExample implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent requestEvent)  {}

    @Override
    public void requestInitialized(ServletRequestEvent requestEvent)  {
        HttpServletRequest servletRequest = (HttpServletRequest)
                requestEvent.getServletRequest();
        System.out.println("Request session ID: " + servletRequest.getSession().
                getId());
        System.out.println("Address: " + servletRequest.getLocalAddr());
    }
}
