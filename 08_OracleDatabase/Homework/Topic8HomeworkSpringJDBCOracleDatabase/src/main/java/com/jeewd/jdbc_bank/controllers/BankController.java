package com.jeewd.jdbc_bank.controllers;

import java.math.BigDecimal;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.UrlConstants;
import com.jeewd.jdbc_bank.entity.BankAccount;
import com.jeewd.jdbc_bank.security.User;
import com.jeewd.jdbc_bank.services.AccountService;
import com.jeewd.jdbc_bank.services.BankOperationService;
import com.jeewd.jdbc_bank.services.CurrencyConversionService;
import com.jeewd.jdbc_bank.utils.UserUtils;

//http://localhost:8080/securebank
@Controller
public class BankController {
    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;
    
    @Autowired
    private BankOperationService bankOperationService;
    
    @Autowired
    private CurrencyConversionService currencyConversionService;
    
    @Secured({"ROLE_USER", "ROLE_BANK_EMPLOYEE"})
    @RequestMapping(value = {"/", UrlConstants.BANK_REGISTER_PAGE_URL},
            method = RequestMethod.GET)
    public String goToBankRegister(Model model) {
        initializeAttributes(model);
        model.addAttribute("accounts", accountService.getAllAccounts());
        
        return "Bankregisterpage";
    }
    
    @Secured("ROLE_BANK_EMPLOYEE")
    @RequestMapping(value = UrlConstants.ACCOUNT_CREATION_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAccountCreation(Model model) {
        initializeAttributes(model);
        
        return "Accountcreation";
    }
    
    @Secured({"ROLE_USER", "ROLE_BANK_EMPLOYEE"})
    @RequestMapping(value = UrlConstants.OPERATION_PAGE_URL,
            method = RequestMethod.GET)
    public String goToOperation(Model model) {
        initializeAttributes(model);
        model.addAttribute("accounts", accountService.getAllAccounts());
        
        return "Operation";
    }
    
    @Secured("ROLE_BANK_EMPLOYEE")
    @RequestMapping(value = UrlConstants.ADD_ACCOUNT_URL,
            method = RequestMethod.POST)
    public String addAccount(Model model, @ModelAttribute(value = "bankAccount")
            BankAccount bankAccount) {
        String username = UserUtils.getUser().getUsername();
        initializeAttributes(model);
        accountService.addAccount(bankAccount, username);
        model.addAttribute("accounts", accountService.getAllAccounts());
        
        return "Bankregisterpage";
    }
    
    @Secured({"ROLE_USER", "ROLE_BANK_EMPLOYEE"})
    @RequestMapping(value = UrlConstants.PROCESS_OPERATION_URL,
            method = RequestMethod.POST)
    public String processOperation(Model model, HttpServletRequest request) {
        User user = UserUtils.getUser();
        String username = "";
        String accountNumber = "";
        BankAccount bankAccount = null;
        Collection<? extends GrantedAuthority> authorities =
                user.getAuthorities();
        String operation = request.getParameter("operation");
        BigDecimal amount = new BigDecimal(0).setScale(2);
        String currency = request.getParameter("currency");
        String accountCurrency = "";
        
        try {
            amount = new BigDecimal(request.getParameter("amount")).setScale(2,
                    BigDecimal.ROUND_HALF_UP);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER")) &&
                !authorities.contains(new SimpleGrantedAuthority(
                        "ROLE_BANK_EMPLOYEE"))) {
            username = user.getUsername();
            accountNumber = request.getParameter("number");
            bankAccount = accountService.getAccountNumberByUsername(username,
                    accountNumber);
        }
        
        if (authorities.contains(new SimpleGrantedAuthority(
                "ROLE_BANK_EMPLOYEE"))) {
            String usernameAndNumber[] = request.getParameter("number").
                    split("/_/");
            username = usernameAndNumber[0];
            accountNumber = usernameAndNumber[1];
            bankAccount = accountService.getAccountNumberByUsername(username,
                    accountNumber);
        }
        
        accountCurrency = bankAccount.getCurrency().toString();
        
        amount = currencyConversionService.convert(amount, currency,
                accountCurrency);
        
        if ("deposit".equals(operation)) {
            bankOperationService.deposit(bankAccount, amount);
        } else if ("withdraw".equals(operation)) {
            bankOperationService.withdraw(bankAccount, amount);
        }
        
        initializeAttributes(model);
        model.addAttribute("accounts", accountService.getAllAccounts());
        
        return "Bankregisterpage";
    }
    
    private static void initializeAttributes(Model model) {
        model.addAttribute("bankRegisterUrl",
                UrlConstants.BANK_REGISTER_PAGE_URL);
        model.addAttribute("createAccountUrl",
                UrlConstants.ACCOUNT_CREATION_PAGE_URL);
        model.addAttribute("operationUrl", UrlConstants.OPERATION_PAGE_URL);
        model.addAttribute("addAccountUrl", UrlConstants.ADD_ACCOUNT_URL);
        model.addAttribute("processOperationUrl",
                UrlConstants.PROCESS_OPERATION_URL);
        model.addAttribute("user", UserUtils.getUser());
    }
}
