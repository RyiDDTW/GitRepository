package com.ddtw.service.impl;

import com.ddtw.dao.StudentDao;
import com.ddtw.domain.Student;
import com.ddtw.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {

        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> findStudent() {

        return studentDao.selectStudent();
    }
}
