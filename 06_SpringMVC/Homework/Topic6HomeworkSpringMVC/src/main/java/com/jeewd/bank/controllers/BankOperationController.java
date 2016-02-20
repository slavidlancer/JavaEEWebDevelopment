package com.jeewd.bank.controllers;

import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.bank.services.BankOperation;
import com.jeewd.bank.services.CurrencyConversion;
import com.jeewd.bank.entities.Account;
import com.jeewd.bank.entities.UserData;

@Controller
public class BankOperationController {
    @Autowired
    private UserData userData;

    @Autowired
    private BankOperation bankOperation;

    @Autowired
    private CurrencyConversion currencyConversion;
    
    private boolean isUserWithAccountPresent;

    @PostConstruct
    void postConstruct() {
        isUserWithAccountPresent = false;
    }

    @RequestMapping(value = "/bankOperations", method = RequestMethod.POST)
    public String handleRequest(Model model, HttpServletRequest request) {
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
            currentAmount = bankOperation.deposit(clientName, initialAmount,
                    changeAmount);
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
                currentAmount = bankOperation.deposit(clientName, currentAmount,
                        changeAmount);
                userData.getUsersWithAccountsList().get(clientName).
                    setCurrentAmount(currentAmount);
            }
        } else if (operation.equals("withdraw") && isUserWithAccountPresent) {
            currentAmount = bankOperation.withdraw(clientName, currentAmount,
                    changeAmount);
            userData.getUsersWithAccountsList().get(clientName).
                setCurrentAmount(currentAmount);
        }
        
        if (isUserWithAccountPresent) {
            userData.getUsersWithAccountsList().get(clientName).
                setCurrentAmount(currentAmount);
        }
        
        accountCurrency = userData.getUsersWithAccountsList().get(clientName).
                getCurrency();
        model.addAttribute("id", clientName);
        model.addAttribute("currentamount", currentAmount);
        model.addAttribute("accountcurrency", accountCurrency);
        
        return "Webbankingpage";
    }
    
    //http://localhost:8080/bank/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String webBankingPage(Model model) {
        return "Webbankingpage";
    }
}
