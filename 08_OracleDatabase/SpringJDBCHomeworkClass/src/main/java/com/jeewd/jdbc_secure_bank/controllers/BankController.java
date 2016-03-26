package com.jeewd.jdbc_secure_bank.controllers;

import java.math.BigDecimal;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeewd.jdbc_secure_bank.dto.BankOperation;
import com.jeewd.jdbc_secure_bank.entity.Account;
import com.jeewd.jdbc_secure_bank.services.WebBank;

@Controller
public class BankController {
    @Inject
    private WebBank webBank;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToBankRegister(Model model) {
        model.addAttribute("accounts", webBank.getAccounts());
        
        return "BankRegister";
    }
    
    @RequestMapping(value = "/bankRegistry", method = RequestMethod.GET)
    public String getAccounts(Model model) {
        model.addAttribute("accounts", webBank.getAccounts());
        
        return "BankRegister";
    }
    
    @RequestMapping(value = "/addAccount", method = RequestMethod.GET)
    public String addAccount() {
        return "AddAccount";
    }
    
    @RequestMapping(value = "/addAccountPost", method = RequestMethod.POST)
    public String addAccountPost(Model model,
            @ModelAttribute("account") Account account) {
        webBank.createAccount(account);
        model.addAttribute("accounts", webBank.getAccounts());
        
        return "BankRegister";
    }
    
    @RequestMapping(value = "/bankAcc", method = RequestMethod.GET)
    public String getBankAccount() {
        return "BankOperation";
    }
    
    @RequestMapping(value = "/bankOp", method = RequestMethod.POST)
    public String bankOperation(Model model,
            @ModelAttribute("bankOp") BankOperation bankOperation) {
        BigDecimal currentAmount = new BigDecimal(0).setScale(2);
        
        //D - deposit, W - withdraw
        if ("D".equals(bankOperation.getOperation())) {
            currentAmount = webBank.deposit(bankOperation.getClient(),
                    bankOperation.getAmount(), bankOperation.getCurrency());
        } else if ("W".equals(bankOperation.getOperation())) {
            currentAmount = webBank.withdraw(bankOperation.getClient(),
                    bankOperation.getAmount(), bankOperation.getCurrency());
        }
        
        model.addAttribute("currentAmount", currentAmount);
        
        return "BankOperation";
    }
}
