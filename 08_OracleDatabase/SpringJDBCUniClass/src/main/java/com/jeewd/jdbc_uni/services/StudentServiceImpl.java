package com.jeewd.jdbc_uni.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.jeewd.jdbc_uni.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {
    private static List<Student> students = new ArrayList<>();
    
    @Override
    public boolean addStudent(Student student) {
        students.add(student);
        
        return true;
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }
}
