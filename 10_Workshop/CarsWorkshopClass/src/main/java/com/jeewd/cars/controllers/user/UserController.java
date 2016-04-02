package com.jeewd.cars.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.cars.dto.user.UserSearch;
import com.jeewd.cars.utils.UserUtils;
import com.jeewd.cars.services.user.UserService;
import com.jeewd.constants.UrlConstants;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = UrlConstants.USERS_REGISTER_URL,
            method = RequestMethod.GET)
    public String getUsers(Model model, @ModelAttribute("UserSearch")
            UserSearch userSearch) {
        model.addAttribute("users", userService.getUsers(
                userSearch.getUsername(), userSearch.getStatus()));
        model.addAttribute("usersRegisterUrl", UrlConstants.USERS_REGISTER_URL);
        model.addAttribute("addUserUrl", UrlConstants.ADD_USER_URL);
        model.addAttribute("user", UserUtils.getUser());
        
        return "usersRegister";
    }
}
