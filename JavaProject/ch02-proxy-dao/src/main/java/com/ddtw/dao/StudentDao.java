package com.ddtw.dao;

import com.ddtw.domain.Student;

import java.util.List;

public interface StudentDao {

    //查询
    public List<Student> selectStudents();

    //插入
    public int insertStudent(Student student);

    //分页查询
    public List<Student> selectAll();
}
