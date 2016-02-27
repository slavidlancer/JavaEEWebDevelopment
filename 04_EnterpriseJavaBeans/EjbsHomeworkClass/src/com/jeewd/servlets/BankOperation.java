package com.jeewd.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jeewd.ejb.WebBank;

@WebServlet("/BankOperation")
public class BankOperation extends HttpServlet {
    private static final long serialVersionUID = 7601127748725388839L;
    
    @EJB
    private WebBank webBank;
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {}
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String client = request.getParameter("client");
        String operation = request.getParameter("operation");
        BigDecimal amount = new BigDecimal(0).setScale(2);
        
        try {
            amount = new BigDecimal(request.getParameter("amount").toString().
                    replaceAll(",", "")).setScale(2);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        
        String currency = request.getParameter("currency");
        BigDecimal currentAmount = new BigDecimal(0).setScale(2);
        
        //D - deposit, W - withdraw
        if ("D".equals(operation)) {
            currentAmount = webBank.deposit(client, amount, currency);
        } else if ("W".equals(operation)) {
            currentAmount = webBank.withdraw(client, amount, currency);
        }
        
        RequestDispatcher requestDispatcher = getServletContext().
                getRequestDispatcher("/BankOperation.jsp");
        request.setAttribute("client", client);
        request.setAttribute("currentAmount", currentAmount);
        requestDispatcher.forward(request, response);
    }
}
