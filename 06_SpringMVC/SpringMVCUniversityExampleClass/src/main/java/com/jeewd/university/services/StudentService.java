package com.jeewd.university.services;

import java.util.List;
import com.jeewd.university.entities.Student;

public interface StudentService {
    boolean addStudent(Student student);
    List<Student> getStudents();
}
