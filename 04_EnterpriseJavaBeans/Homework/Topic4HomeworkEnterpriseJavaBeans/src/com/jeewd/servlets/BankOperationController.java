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
    private static final String CURRENCY_BGN = "bgn";
    private static final String CURRENCY_USD = "usd";
    private static final String CURRENCY_EUR = "eur";
    private static final BigDecimal EXCHANGE_RATE_BGN_TO_EUR =
            new BigDecimal(0.511292);
    private static final BigDecimal EXCHANGE_RATE_EUR_TO_BGN =
            new BigDecimal(1.95583);
    
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
        String rawAccountCurrency = request.getParameter("accountcurrency");
        String accountCurrency;
        BigDecimal changeAmount = new BigDecimal(0);
        String changeCurrency = request.getParameter("changecurrency");
        boolean incorrectBigDecimalValues = false;
        BigDecimal exchangeRateUSDtoEUR = new BigDecimal(0.894269);
        BigDecimal exchangeRateEURtoUSD = new BigDecimal(1.11823);
        BigDecimal exchangeRateUSDtoBGN = new BigDecimal(1.76185);
        BigDecimal exchangeRateBGNtoUSD = new BigDecimal(0.567585);
        
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
        
        if (!client.equals(httpSession.getAttribute("id"))) {
            if (BankOperationController.CURRENCY_BGN.
                    equals(rawAccountCurrency)) {
                bankOperation.setCurrency(client, 
                        BankOperationController.CURRENCY_BGN);
                httpSession.setAttribute("accountcurrency", "bgn");
                httpSession.setAttribute("selectedbgn", "selected");
                httpSession.setAttribute("selectedusd", "");
                httpSession.setAttribute("selectedeur", "");
            } else if (BankOperationController.CURRENCY_USD.
                    equals(rawAccountCurrency)) {
                bankOperation.setCurrency(client,
                        BankOperationController.CURRENCY_USD);
                httpSession.setAttribute("accountcurrency", "usd");
                httpSession.setAttribute("selectedbgn", "");
                httpSession.setAttribute("selectedusd", "selected");
                httpSession.setAttribute("selectedeur", "");
            } else if (BankOperationController.CURRENCY_EUR.
                    equals(rawAccountCurrency)) {
                bankOperation.setCurrency(client,
                        BankOperationController.CURRENCY_EUR);
                httpSession.setAttribute("accountcurrency", "eur");
                httpSession.setAttribute("selectedbgn", "");
                httpSession.setAttribute("selectedusd", "");
                httpSession.setAttribute("selectedeur", "selected");
            }
        } else if (BankOperationController.CURRENCY_BGN.
                equals(rawAccountCurrency) && BankOperationController.
                CURRENCY_BGN.equals(httpSession.
                        getAttribute("accountcurrency"))) {
            httpSession.setAttribute("selectedbgn", "selected");
            httpSession.setAttribute("selectedusd", "");
            httpSession.setAttribute("selectedeur", "");
        } else if (BankOperationController.CURRENCY_USD.
                equals(rawAccountCurrency) && BankOperationController.
                CURRENCY_USD.equals(httpSession.
                        getAttribute("accountcurrency"))) {
            httpSession.setAttribute("selectedbgn", "");
            httpSession.setAttribute("selectedusd", "selected");
            httpSession.setAttribute("selectedeur", "");
        } else if (BankOperationController.CURRENCY_EUR.
                equals(rawAccountCurrency) && BankOperationController.
                CURRENCY_EUR.equals(httpSession.
                        getAttribute("accountcurrency"))) {
            httpSession.setAttribute("selectedbgn", "");
            httpSession.setAttribute("selectedusd", "");
            httpSession.setAttribute("selectedeur", "selected");
        }
        
        accountCurrency = (String) httpSession.getAttribute("accountcurrency");
        
        if (BankOperationController.CURRENCY_BGN.equals(accountCurrency)) {
            if (!accountCurrency.equals(changeCurrency)) {
                if (BankOperationController.CURRENCY_USD.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    exchangeRateUSDtoBGN);
                } else if (BankOperationController.CURRENCY_EUR.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    BankOperationController.
                                    EXCHANGE_RATE_EUR_TO_BGN); //Euro is fixed
                }
            }
        } else if (BankOperationController.CURRENCY_USD.
                equals(accountCurrency)) {
            if (!accountCurrency.equals(changeCurrency)) {
                if (BankOperationController.CURRENCY_BGN.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    exchangeRateBGNtoUSD);
                } else if (BankOperationController.CURRENCY_EUR.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    exchangeRateEURtoUSD);
                }
            }
        } else if (BankOperationController.CURRENCY_EUR.
                equals(accountCurrency)) {
            if (!accountCurrency.equals(changeCurrency)) {
                if (BankOperationController.CURRENCY_BGN.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    BankOperationController.
                                    EXCHANGE_RATE_BGN_TO_EUR); //fixed exchange rate
                } else if (BankOperationController.CURRENCY_USD.
                        equals(changeCurrency)) {
                    changeAmount = currencyConversion.
                            convertFromCurrencyToAnother(changeAmount,
                                    exchangeRateUSDtoEUR);
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
