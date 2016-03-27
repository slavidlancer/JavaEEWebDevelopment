package com.jeewd.jpa_h_uni.services;

import java.util.List;

import com.jeewd.jpa_h_uni.entities.Student;

public interface StudentService {
    boolean addStudent(Student student);
    List<Student> getStudents();
}
