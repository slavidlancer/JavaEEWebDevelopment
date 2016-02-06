package com.jeewd.servlets;

import java.io.IOException;
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
                + "\nPlease wait ....\nPossible error occurred!\nPlease enter"
                + "proper values!");
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpRequest.getSession();
        httpSession.setAttribute("responsemessage", "");
        
        String client = request.getParameter("id");
        double currentAmount = (Double.parseDouble(request.getParameter(
                "currentamount").replaceAll(",", ""))); //try-catch
        String operation = request.getParameter("operation");
        double changeAmount = (Double.parseDouble(request.getParameter(
                "changeamount").replaceAll(",", ""))); //try-catch
        
        if (operation.equals("deposit")) {
            currentAmount = bankOperation.deposit(client, currentAmount,
                    changeAmount);
        } else if (operation.equals("withdraw")) {
            currentAmount = bankOperation.withdraw(client, currentAmount,
                    changeAmount);
        } else {
            response.getWriter().println("Unknown operation!");
        }
        
        if (bankOperation.doesNotContainClient(client)) {
            httpSession.setAttribute("responsemessage", "New Client, no "
                    + "withdraws are allowed! Deposits only.");
        }
        
        System.out.println(client + " " + currentAmount + " " + changeAmount);
        
        httpSession.setAttribute("id", client);
        httpSession.setAttribute("currentamount", currentAmount);
        
        httpResponse.sendRedirect("pages/Webbankingpage.jsp");
    }
}
