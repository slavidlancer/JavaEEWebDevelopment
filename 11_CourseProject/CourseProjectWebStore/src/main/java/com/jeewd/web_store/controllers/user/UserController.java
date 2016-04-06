package com.jeewd.web_store.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.JspNameConstants;
import com.jeewd.constants.UrlConstants;

@Controller
public class UserController {
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.USER_REGISTRY_PAGE_URL,
            method = RequestMethod.GET)
    public String goToUserRegistryPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.USER_REGISTRY_PAGE;
    }
    
    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.USER_ADD_PAGE_URL,
            method = RequestMethod.GET)
    public String goToAddUserPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.ADD_EDIT_USER_PAGE;
    }
    
    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping(value = UrlConstants.USER_EDIT_PAGE_URL,
            method = RequestMethod.GET)
    public String goToEditUserPage(Model model) {
        initializeAttributes(model);
        
        return JspNameConstants.ADD_EDIT_USER_PAGE;
    }
    
    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = UrlConstants.USER_DELETE_URL,
            method = RequestMethod.GET)
    public String deleteUser(Model model) {
        initializeAttributes(model);
        
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