package com.jeewd.jdbc_uni.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.jeewd.jdbc_uni.entities.Student;

@Service("studentServiceDb")
public class StudentServiceDbImpl implements StudentService {
    @Override
    public boolean addStudent(Student student) {
        return false;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setFacultyNumber("New Impl");
        student.setName("New Name");
        students.add(student);
        
        return students;
    }
}
