package com.jeewd.securebank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.UrlConstants;

@Controller
public class BankController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToDefaultPage(Model model) {
        //model.addAttribute("students", studentService.getStudents());
        /*model.addAttribute("addStudentUrl",
                UrlConstants.ADD_STUDENT_URL);*/
        //model.addAttribute("user", UserUtils.getUser());
        
        return "Bankregisterpage";
    }
    
    @RequestMapping(value = UrlConstants.BANK_REGISTER_PAGE_URL,
            method = RequestMethod.GET)
    public String goToBankRegister(Model model) {
        //model.addAttribute("students", studentService.getStudents());
        /*model.addAttribute("addStudentUrl",
                UrlConstants.ADD_STUDENT_URL);*/
        //model.addAttribute("user", UserUtils.getUser());
        
        return "Bankregisterpage";
    }
    
    @RequestMapping(value = UrlConstants.ACCOUNT_CREATION_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAccountCreation(Model model) {
        //model.addAttribute("students", studentService.getStudents());
        /*model.addAttribute("addStudentUrl",
                UrlConstants.ADD_STUDENT_URL);*/
        //model.addAttribute("user", UserUtils.getUser());
        
        return "Accountcreation";
    }
    
    @RequestMapping(value = UrlConstants.OPERATION_PAGE_URL,
            method = RequestMethod.GET)
    public String goToOperation(Model model) {
        //model.addAttribute("students", studentService.getStudents());
        /*model.addAttribute("addStudentUrl",
                UrlConstants.ADD_STUDENT_URL);*/
        //model.addAttribute("user", UserUtils.getUser());
        
        return "Operation";
    }
}
