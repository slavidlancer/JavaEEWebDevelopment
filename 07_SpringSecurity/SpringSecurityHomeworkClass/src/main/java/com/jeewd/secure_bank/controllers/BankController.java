package com.jeewd.secure_bank.controllers;

import java.math.BigDecimal;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeewd.secure_bank.dto.BankOperation;
import com.jeewd.secure_bank.services.WebBank;

@Controller
public class BankController {
    @Inject
    private WebBank webBank;
    
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
