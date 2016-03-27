package com.jeewd.jpa_h_uni.dao;

import java.util.List;

import com.jeewd.jpa_h_uni.entities.Student;

public interface StudentDao {
    List<Student> getStudents();
    boolean addStudent(Student student);
}
