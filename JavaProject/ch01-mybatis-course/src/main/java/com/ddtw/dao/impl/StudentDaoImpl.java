package com.ddtw.dao.impl;

import com.ddtw.dao.StudentDao;
import com.ddtw.domain.Student;
import com.ddtw.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        String sqlId = "com.ddtw.dao.StudentDao.selectStudent";

        List<Student> students = sqlSession.selectList(sqlId);

        sqlSession.close();;
        return students;

    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession =MyBatisUtils.getSqlSession();
        //6.【重要】指定要执行的语句。sql映射文件汇总namespace + "." +标签的id值
        String sqlId = "com.ddtw.dao.StudentDao" + "." + "insertStudent";
        //7.执行sql语句，通过sqlId找到语句
        int num = sqlSession.insert(sqlId,student);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }
}
