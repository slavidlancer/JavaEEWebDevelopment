package com.jeewd.university.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jeewd.university.entities.Student;
import com.jeewd.university.services.StudentService;
import com.jeews.university.constants.UrlConstants;

@Controller
public class StudentController {
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;
    
    @RequestMapping(value = UrlConstants.STUDENT_REGISTER_URL,
            method = RequestMethod.GET)
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getStudents());
        model.addAttribute("addStudentUrl",
                UrlConstants.STUDENT_ADD_STUDENT_URL);
        
        return "studentsRegister";
    }
    
    @RequestMapping(value = UrlConstants.STUDENT_ADD_STUDENT_URL,
            method = RequestMethod.GET)
    public String addStudent(Model model) {
        Student student = new Student();
        student.setName("Set in Controller");
        model.addAttribute("student", student);
        
        return "addStudent";
    }
    
    @RequestMapping(value = "/addStudentSave", method = RequestMethod.POST)
    public String addStudent(Model model,
            @ModelAttribute("student") Student student,
            HttpServletRequest request) {
        studentService.addStudent(student);
        model.addAttribute("students", studentService.getStudents());
        
        return "studentsRegister";
    }
}
