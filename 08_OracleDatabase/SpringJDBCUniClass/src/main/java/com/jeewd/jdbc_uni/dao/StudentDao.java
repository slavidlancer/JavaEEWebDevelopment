package com.jeewd.jdbc_uni.dao;

import java.util.List;
import com.jeewd.jdbc_uni.entities.Student;

public interface StudentDao {
    List<Student> getStudents();
    boolean addStudent(Student student);
}
