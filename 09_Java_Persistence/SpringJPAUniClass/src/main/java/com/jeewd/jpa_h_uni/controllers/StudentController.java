package com.jeewd.jpa_h_uni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.constants.UrlConstants;
import com.jeewd.jpa_h_uni.entities.Student;
import com.jeewd.jpa_h_uni.services.StudentService;
import com.jeewd.jpa_h_uni.utils.UserUtils;

@Controller
public class StudentController {
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultPage(Model model) {
        model.addAttribute("students", studentService.getStudents());
        model.addAttribute("addStudentUrl",
                UrlConstants.ADD_STUDENT_URL);
        model.addAttribute("user", UserUtils.getUser());
        
        return "studentsRegister";
    }
    
    //@Secured("ROLE_USER")
    @RequestMapping(value = UrlConstants.STUDENT_REGISTER_URL,
            method = RequestMethod.GET)
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getStudents());
        model.addAttribute("addStudentUrl",
                UrlConstants.ADD_STUDENT_URL);
        model.addAttribute("user", UserUtils.getUser());
        
        return "studentsRegister";
    }
    
    @RequestMapping(value = UrlConstants.ADD_STUDENT_URL,
            method = RequestMethod.GET)
    public String addStudent(Model model) {
        return "addStudent";
    }
    
    @RequestMapping(value = UrlConstants.ADD_STUDENT_SAVE_URL,
            method = RequestMethod.POST)
    public String addStudent(Model model,
            @ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        model.addAttribute("students", studentService.getStudents());
        
        return "studentsRegister";
    }
}
