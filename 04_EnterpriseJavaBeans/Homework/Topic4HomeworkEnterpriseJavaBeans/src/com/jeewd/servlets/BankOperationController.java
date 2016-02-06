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
        httpSession.setAttribute("newclientmessage", "");
        httpSession.setAttribute("incorrectamount", "");
        
        String rawClient = request.getParameter("id");
        String client;
        BigDecimal currentAmount = new BigDecimal(request.getParameter(
                "currentamount").replaceAll(",", "")); //try-catch
        String operation = request.getParameter("operation");
        BigDecimal changeAmount = new BigDecimal(request.getParameter(
                "changeamount").replaceAll(",", "")); //try-catch
        
        if (rawClient.equals(null) || rawClient.equals("")) {
            client = "undefined client";
        } else {
            client = rawClient;
        }
        
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
            httpSession.setAttribute("newclientmessage", "New Client added, no "
                    + "withdraws were allowed! Deposits only.");
        }
        
        if (bankOperation.incorrectAmountToChange()) {
            httpSession.setAttribute("incorrectamount", "Incorrect amount "
                    + "to change!<br>Please enter proper values: deposit and "
                    + "withdraw amounts<br>should be positive values,<br>"
                    + "withdraw operation can be fulfilled with amount<br>"
                    + "less than 50 % of the current amount!");
        }
        
        httpSession.setAttribute("id", client);
        httpSession.setAttribute("currentamount", currentAmount);
        
        httpResponse.sendRedirect("pages/Webbankingpage.jsp");
    }
}
