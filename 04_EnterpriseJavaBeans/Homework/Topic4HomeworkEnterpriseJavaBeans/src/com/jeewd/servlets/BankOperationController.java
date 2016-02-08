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
import com.jeewd.ejbs.CurrencyConversion;

@WebServlet("/BankOperationController")
public class BankOperationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String currencyBGN = "bgn";
    private static final String currencyUSD = "usd";
    private static final String currencyEUR = "eur";
    
    @EJB(beanName = "BankOperationImpl")
    private BankOperation bankOperation;
    
    @EJB
    private CurrencyConversion currencyConversion;

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
        BigDecimal currentAmount = new BigDecimal(0);
        String accountCurrency = request.getParameter("accountcurrency");
        BigDecimal changeAmount = new BigDecimal(0);
        String changeCurrency = request.getParameter("changecurrency");
        boolean incorrectBigDecimalValues = false;
        
        try {
            currentAmount = new BigDecimal(request.getParameter(
                    "currentamount").replaceAll(",", ""));
        } catch (NumberFormatException nfe) {
            incorrectBigDecimalValues = true;
        }
        
        try {
            changeAmount = new BigDecimal(request.getParameter(
                    "changeamount").replaceAll(",", ""));
        } catch (NumberFormatException nfe) {
            incorrectBigDecimalValues = true;
        }
        
        String operation = request.getParameter("operation");
        
        if (rawClient == null || rawClient.equals("")) {
            client = "undefined client";
        } else {
            client = rawClient;
        }
        
        if (BankOperationController.currencyBGN.equals(accountCurrency)) {
            bankOperation.setCurrency(client,
                    BankOperationController.currencyBGN);
            httpSession.setAttribute("selectedbgn", "selected");
            httpSession.setAttribute("selectedusd", "");
            httpSession.setAttribute("selectedeur", "");
            
            if (!accountCurrency.equals(changeCurrency)) {
                if (BankOperationController.currencyUSD.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    new BigDecimal(1.76185));
                } else if (BankOperationController.currencyEUR.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    new BigDecimal(1.95583)); //Euro is fixed
                }
            }
        } else if (BankOperationController.currencyUSD.
                equals(accountCurrency)) {
            bankOperation.setCurrency(client,
                    BankOperationController.currencyUSD);
            httpSession.setAttribute("selectedbgn", "");
            httpSession.setAttribute("selectedusd", "selected");
            httpSession.setAttribute("selectedeur", "");
            
            if (!accountCurrency.equals(changeCurrency)) {
                if (BankOperationController.currencyBGN.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    new BigDecimal(0.567585));
                } else if (BankOperationController.currencyEUR.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    new BigDecimal(1.50));
                }
            }
        } else if (BankOperationController.currencyEUR.
                equals(accountCurrency)) {
            bankOperation.setCurrency(client,
                    BankOperationController.currencyEUR);
            httpSession.setAttribute("selectedbgn", "");
            httpSession.setAttribute("selectedusd", "");
            httpSession.setAttribute("selectedeur", "selected");
            
            if (!accountCurrency.equals(changeCurrency)) {
                if (BankOperationController.currencyBGN.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    new BigDecimal(0.511292)); //fixed exchange rate
                } else if (BankOperationController.currencyUSD.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    new BigDecimal(1.50));
                }
            }
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
        
        if (bankOperation.incorrectAmountToChange() ||
                incorrectBigDecimalValues) {
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
