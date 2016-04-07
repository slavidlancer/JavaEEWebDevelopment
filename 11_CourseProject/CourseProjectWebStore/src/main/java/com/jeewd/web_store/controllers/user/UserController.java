package com.jeewd.web_store.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.JspNameConstants;
import com.jeewd.constants.UrlConstants;
import com.jeewd.web_store.dto.user.UserSearch;
import com.jeewd.web_store.dto.user.UserTransfer;
import com.jeewd.web_store.services.user.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.USER_REGISTRY_PAGE_URL,
            method = RequestMethod.GET)
    public String goToUserRegistryPage(Model model,
            @ModelAttribute("UserSearch") UserSearch userSearch) {
        initializeAttributes(model);
        
        if (userSearch != null) {
            model.addAttribute("users",
                    userService.getUsersBySearch(userSearch));
        } else {
            model.addAttribute("users", userService.getAllUsers());
        }
        
        return JspNameConstants.USER_REGISTRY_PAGE;
    }
    
    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.USER_ADD_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAddUserPage(Model model,
            @ModelAttribute("User") UserTransfer userTransfer) {
        initializeAttributes(model);
        
        return JspNameConstants.ADD_EDIT_USER_PAGE;
    }
    
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.USER_EDIT_PAGE_URL,
            method = RequestMethod.GET)
    public String goToEditUserPage(Model model,
            @ModelAttribute("User") UserTransfer userTransfer) {
        initializeAttributes(model);
        model.addAttribute("user",
                userService.getUserById(userTransfer.getId()));
        
        return JspNameConstants.ADD_EDIT_USER_PAGE;
    }
    
    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.USER_ADD_EDIT_URL,
            method = RequestMethod.GET)
    public String addEditOrder(Model model,
            @ModelAttribute("User") UserTransfer userTransfer) {
        initializeAttributes(model);
        
        if (userTransfer.getId() != null) {
            userService.updateUser(userTransfer);
        } else {
            userService.addUser(userTransfer);
        }
        
        return JspNameConstants.USER_REGISTRY_PAGE;
    }
    
    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.USER_DELETE_URL,
            method = RequestMethod.GET)
    public String deleteUser(Model model,
            @ModelAttribute("User") UserTransfer userTransfer) {
        initializeAttributes(model);
        userService.deleteUserById(userTransfer.getId());
        
        return JspNameConstants.USER_REGISTRY_PAGE;
    }
    
    private static void initializeAttributes(Model model) {
        model.addAttribute("userRegistryPageUrl",
                UrlConstants.USER_REGISTRY_PAGE_URL);
        model.addAttribute("addUserPageUrl",
                UrlConstants.USER_ADD_PAGE_URL);
        model.addAttribute("editUserPageUrl",
                UrlConstants.USER_EDIT_PAGE_URL);
        model.addAttribute("addEditUserUrl",
                UrlConstants.USER_ADD_EDIT_URL);
        model.addAttribute("deleteUserUrl",
                UrlConstants.USER_DELETE_URL);
        //model.addAttribute("user", UserUtils.getUser());
    }
}
