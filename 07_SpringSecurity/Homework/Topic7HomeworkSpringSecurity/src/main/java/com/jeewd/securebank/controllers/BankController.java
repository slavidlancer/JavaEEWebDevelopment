package com.jeewd.securebank.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

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
import com.jeewd.securebank.entity.BankAccount;
import com.jeewd.securebank.security.User;
import com.jeewd.securebank.services.AccountService;
import com.jeewd.securebank.services.BankOperationService;
import com.jeewd.securebank.utils.UserUtils;

//http://localhost:8080/securebank
@Controller
public class BankController {
    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;
    
    @Autowired
    private BankOperationService bankOperationService;
    
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
        String username = user.getUsername();
        Collection<? extends GrantedAuthority> authorities =
                user.getAuthorities();
        String accountNumber = request.getParameter("number");
        
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER")) &&
                !authorities.contains(new SimpleGrantedAuthority(
                        "ROLE_BANK_EMPLOYEE"))) {
            System.out.println("role_user");
        }
        
        if (authorities.contains(new SimpleGrantedAuthority(
                "ROLE_BANK_EMPLOYEE"))) {
            System.out.println("role_bank_employee");
        }
        
        System.out.println(username);
        System.out.println(accountNumber);
        
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
