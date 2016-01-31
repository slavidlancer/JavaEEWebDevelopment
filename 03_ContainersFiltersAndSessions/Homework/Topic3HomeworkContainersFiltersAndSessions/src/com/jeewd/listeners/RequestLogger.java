package com.jeewd.listeners;

import java.util.Date;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestLogger implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent requestEvent) {}

    @Override
    public void requestInitialized(ServletRequestEvent requestEvent) {
        Date dateValue = new Date();
        HttpServletRequest servletRequest = (HttpServletRequest)
                requestEvent.getServletRequest();
        String requestUserName = servletRequest.getParameter("user");
        
        System.out.println("#\tRequest       #");
        System.out.println("[IP address: " + servletRequest.getRemoteAddr());
        System.out.println("Session ID: " + servletRequest.getSession().
                getId());
        
        if (requestUserName == null) {
            System.out.println("Request type: Normal request");
        } else {
            System.out.println("Request type: Login attempt");
        }
        
        /*System.out.println("Dispatcher type: " +
                servletRequest.getDispatcherType());*/
        System.out.println("Date and time: " + dateValue + "]\n##");
    }
}
