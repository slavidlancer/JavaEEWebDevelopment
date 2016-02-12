package com.jeewd.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.beans.HelloWorld;

@Controller
public class HomeController {
    @Autowired
    private HelloWorld helloWorld;
    
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate + " " + 
                helloWorld.sayHello());
        
        return "home";
    }
}
