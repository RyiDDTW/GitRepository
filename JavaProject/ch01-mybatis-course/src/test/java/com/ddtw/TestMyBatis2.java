package com.ddtw;

import com.ddtw.dao.StudentDao;
import com.ddtw.dao.impl.StudentDaoImpl;
import com.ddtw.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis2 {
    @Test
    public void testSelectStudents(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudents();
        studentList.forEach( stu -> System.out.println(stu));
    }
}
