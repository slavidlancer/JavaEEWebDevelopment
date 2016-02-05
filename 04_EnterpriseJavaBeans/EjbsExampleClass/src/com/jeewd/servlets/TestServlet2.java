package com.jeewd.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jeewd.ejbs.SingletonBean;
import com.jeewd.ejbs.StatefulHelloWorld;
import com.jeewd.ejbs.StatelessHelloWorld;

@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @EJB(beanName = "StatelessHelloWorldImpl")
    private StatelessHelloWorld statelessHelloWorld;
    
    @EJB
    private StatefulHelloWorld statefulHelloWorld;
    
    @EJB
    private SingletonBean singletonBean;

    public TestServlet2() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(statelessHelloWorld.helloStatelessEjb());
        response.getWriter().println(statefulHelloWorld.statefulHelloWorld());
        response.getWriter().println(singletonBean.singletonHelloWorld());
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
