package com.ddtw;

import com.ddtw.dao.StudentDao;

import com.ddtw.domain.Student;
import com.ddtw.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis2 {
    @Test
    public void testSelectStudents(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = dao.selectStudents();
        studentList.forEach( stu -> System.out.println(stu));
        sqlSession.close();

    }
    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1006);
        student.setName("关于");
        student.setEmail("guanyu@qq.com");
        student.setAge(24);
        int num = dao.insertStudent(student);
        System.out.println("插入了" + num + "条数据");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        PageHelper.startPage(1,3);
        List<Student> studentList = dao.selectAll();
        studentList.forEach( stu -> System.out.println(stu));
        sqlSession.close();

    }
}
