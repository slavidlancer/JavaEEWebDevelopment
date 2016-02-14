package com.jeewd.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.jeewd.ejbs.BankOperation;

@WebServlet("/BankOperationController")
public class BankOperationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @EJB(beanName = "BankOperationImpl")
    private BankOperation bankOperation;

    public BankOperationController() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
        response.getWriter().println("Processing Bank Operations .... "
                + "\nPlease wait ....\nPossible error occurred!\nPlease, enter "
                + "proper values!\nPlease, reload again the Web Banking Page "
                + "or go back!");
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpRequest.getSession();
        
        String rawClientName = request.getParameter("id");
        String clientName;
        BigDecimal currentAmount = new BigDecimal(0);
        BigDecimal changeAmount = new BigDecimal(0);
        String operation = request.getParameter("operation");
        
        if (rawClientName == null || rawClientName.equals("")) {
            clientName = "undefined client";
        } else {
            clientName = rawClientName;
        }
        
        if (operation.equals("deposit")) {
            currentAmount = bankOperation.deposit(clientName, currentAmount,
                    changeAmount);
        } else if (operation.equals("withdraw")) {
            currentAmount = bankOperation.withdraw(clientName, currentAmount,
                    changeAmount);
        } else {
            response.getWriter().println("Unknown operation!");
        }
        
        httpSession.setAttribute("id", clientName);
        httpSession.setAttribute("currentamount", currentAmount);
        
        httpResponse.sendRedirect("pages/Webbankingpage.jsp");
    }
}
