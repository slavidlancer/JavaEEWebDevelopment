package com.jeewd.securebank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.UrlConstants;
import com.jeewd.securebank.utils.UserUtils;

@Controller
public class BankController {
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
        model.addAttribute("username", UserUtils.getUser());
        
        return "Bankregisterpage";
    }
    
    @RequestMapping(value = UrlConstants.BANK_REGISTER_PAGE_URL,
            method = RequestMethod.GET)
    public String goToBankRegister(Model model) {
        return "Bankregisterpage";
    }
    
    @RequestMapping(value = UrlConstants.ACCOUNT_CREATION_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAccountCreation(Model model) {
        return "Accountcreation";
    }
    
    @RequestMapping(value = UrlConstants.OPERATION_PAGE_URL,
            method = RequestMethod.GET)
    public String goToOperation(Model model) {
        return "Operation";
    }
    
    @RequestMapping(value = UrlConstants.ADD_ACCOUNT_URL,
            method = RequestMethod.POST)
    public String addAccount(Model model) {
        return "Bankregisterpage";
    }
    
    @RequestMapping(value = UrlConstants.PROCESS_OPERATION_URL,
            method = RequestMethod.POST)
    public String processOperation(Model model) {
        return "Bankregisterpage";
    }
}
