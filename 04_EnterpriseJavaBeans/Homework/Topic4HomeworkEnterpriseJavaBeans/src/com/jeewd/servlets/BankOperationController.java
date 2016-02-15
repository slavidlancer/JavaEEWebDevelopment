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
import com.jeewd.ejbs.Account;
import com.jeewd.ejbs.BankOperation;
import com.jeewd.ejbs.CurrencyConversion;
import com.jeewd.ejbs.UserData;

@WebServlet("/BankOperationController")
public class BankOperationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @EJB
    private UserData userData;
    
    @EJB(beanName = "BankOperationImpl")
    private BankOperation bankOperation;
    
    @EJB
    private CurrencyConversion currencyConversion;
    
    private boolean isUserWithAccountPresent;

    public BankOperationController() {
        super();
        isUserWithAccountPresent = false;
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
        BigDecimal initialAmount = new BigDecimal(0).setScale(2);
        BigDecimal currentAmount = new BigDecimal(0).setScale(2);
        BigDecimal changeAmount = new BigDecimal(0).setScale(2);
        String operation = request.getParameter("operation");
        String accountCurrency = request.getParameter("changecurrency");
        
        if (rawClientName == null || rawClientName.equals("")) {
            clientName = "undefined client";
        } else {
            clientName = rawClientName;
        }
        
        try {
            changeAmount = new BigDecimal(request.getParameter(
                    "changeamount").replaceAll(",", ""));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        
        if (userData.getUsersWithAccountsList().containsKey(clientName)) {
            currentAmount = userData.getUsersWithAccountsList().get(clientName).
                    getCurrentAmount();
            isUserWithAccountPresent = true;
        } else {
            userData.getUsersWithAccountsList().put(clientName, new Account(
                    initialAmount, accountCurrency));
            currentAmount = bankOperation.deposit(initialAmount, changeAmount);
            userData.getUsersWithAccountsList().get(clientName).
                setCurrentAmount(currentAmount);
            isUserWithAccountPresent = false;
        }
        
        if (!(changeAmount.compareTo(new BigDecimal(0)) == 0)) {
            changeAmount = currencyConversion.convert(changeAmount,
                    accountCurrency, userData.getUsersWithAccountsList().
                    get(clientName).getCurrency());
        }
        
        if (operation.equals("deposit")) {
            if (isUserWithAccountPresent) {
                currentAmount = bankOperation.deposit(currentAmount,
                        changeAmount);
                userData.getUsersWithAccountsList().get(clientName).
                    setCurrentAmount(currentAmount);
            }
        } else if (operation.equals("withdraw") && isUserWithAccountPresent) {
            currentAmount = bankOperation.withdraw(currentAmount, changeAmount);
            userData.getUsersWithAccountsList().get(clientName).
                setCurrentAmount(currentAmount);
        } else {
            response.getWriter().println("Unknown operation!");
        }
        
        if (isUserWithAccountPresent) {
            userData.getUsersWithAccountsList().get(clientName).
                setCurrentAmount(currentAmount);
        }
        
        accountCurrency = userData.getUsersWithAccountsList().get(clientName).
                getCurrency();
        httpSession.setAttribute("id", clientName);
        httpSession.setAttribute("currentamount", currentAmount);
        httpSession.setAttribute("accountcurrency", accountCurrency);
        
        httpResponse.sendRedirect("pages/Webbankingpage.jsp");
    }
}
