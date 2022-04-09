package com.ddtw.service;

import com.ddtw.domain.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);
    List<Student> findStudent();
}
