package com.jeewd.jdbc_uni.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeewd.jdbc_uni.dao.StudentDao;
import com.jeewd.jdbc_uni.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {
    //private static List<Student> students = new ArrayList<>();
    
    @Autowired
    private StudentDao studentDao;
    
    @Override
    public boolean addStudent(Student student) {
        /*students.add(student);
        
        return true;*/
        
        return studentDao.addStudent(student);
    }

    @Override
    public List<Student> getStudents() {
        //return students;
        
        return studentDao.getStudents();
    }
}
