package com.jeewd.jdbc_uni.services;

import java.util.List;
import com.jeewd.jdbc_uni.entities.Student;

public interface StudentService {
    boolean addStudent(Student student);
    List<Student> getStudents();
}
