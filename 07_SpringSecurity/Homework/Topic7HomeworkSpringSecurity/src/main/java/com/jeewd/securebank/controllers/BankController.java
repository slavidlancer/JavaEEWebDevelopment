package com.jeewd.securebank.controllers;

import javax.inject.Inject;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.UrlConstants;
import com.jeewd.securebank.dto.BankOperation;
import com.jeewd.securebank.entity.BankAccount;
import com.jeewd.securebank.services.AccountService;
import com.jeewd.securebank.utils.UserUtils;

@Controller
public class BankController {
    @Inject
    private AccountService accountService;
    
    @Secured({"ROLE_USER", "ROLE_BANK_EMPLOYEE"})
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToDefaultPage(Model model) {
        model.addAttribute("bankRegisterUrl",
                UrlConstants.BANK_REGISTER_PAGE_URL);
        model.addAttribute("createAccountUrl",
                UrlConstants.ACCOUNT_CREATION_PAGE_URL);
        model.addAttribute("operationUrl", UrlConstants.OPERATION_PAGE_URL);
        model.addAttribute("addAccountUrl", UrlConstants.ADD_ACCOUNT_URL);
        model.addAttribute("processOperationUrl",
                UrlConstants.PROCESS_OPERATION_URL);
        model.addAttribute("user", UserUtils.getUser());
        
        return "Bankregisterpage";
    }
    
    @Secured({"ROLE_USER", "ROLE_BANK_EMPLOYEE"})
    @RequestMapping(value = UrlConstants.BANK_REGISTER_PAGE_URL,
            method = RequestMethod.GET)
    public String goToBankRegister(Model model) {
        return "Bankregisterpage";
    }
    
    @Secured("ROLE_BANK_EMPLOYEE")
    @RequestMapping(value = UrlConstants.ACCOUNT_CREATION_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAccountCreation(Model model) {
        return "Accountcreation";
    }
    
    @Secured({"ROLE_USER", "ROLE_BANK_EMPLOYEE"})
    @RequestMapping(value = UrlConstants.OPERATION_PAGE_URL,
            method = RequestMethod.GET)
    public String goToOperation(Model model) {
        return "Operation";
    }
    
    @Secured("ROLE_BANK_EMPLOYEE")
    @RequestMapping(value = UrlConstants.ADD_ACCOUNT_URL,
            method = RequestMethod.POST)
    public String addAccount(Model model, @ModelAttribute("bankAccount")
            BankAccount bankAccount) {
        /*accountService.addAccount(bankAccount.getUsername(),
                bankAccount.getNumber(), bankAccount.getAmount(),
                bankAccount.getCurrency());
        model.addAttribute("accounts", accountService.getAccounts(bankAccount.
                getUsername()));*/
        
        return "Bankregisterpage";
    }
    
    @Secured({"ROLE_USER", "ROLE_BANK_EMPLOYEE"})
    @RequestMapping(value = UrlConstants.PROCESS_OPERATION_URL,
            method = RequestMethod.POST)
    public String processOperation(Model model, @ModelAttribute("bankOperation")
            BankOperation bankOperation) {
        return "Bankregisterpage";
    }
}
