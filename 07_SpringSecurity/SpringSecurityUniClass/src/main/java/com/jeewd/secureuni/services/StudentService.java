package com.jeewd.secureuni.services;

import java.util.List;
import com.jeewd.secureuni.entities.Student;

public interface StudentService {
    boolean addStudent(Student student);
    List<Student> getStudents();
}
