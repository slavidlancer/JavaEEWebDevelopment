package com.jeewd.secure_bank.services;

import java.util.List;

import com.jeewd.secure_bank.entities.Student;

public interface StudentService {
    boolean addStudent(Student student);
    List<Student> getStudents();
}
