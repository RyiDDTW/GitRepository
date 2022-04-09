package com.ddtw;

import com.ddtw.domain.Student;
import com.ddtw.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) {
        //访问mybatis读取数据库数据

        //5.【重要】获取SqkSession对象，从SqlSessionFactory中获取SqkSession
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //6.【重要】指定要执行的语句。sql映射文件汇总namespace + "." +标签的id值
        String sqlId = "com.ddtw.dao.StudentDao" + "." + "selectStudent";
        //7.执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
        studentList.forEach( stu -> System.out.println(stu));
        //9.关闭SqlSession对象
        sqlSession.close();
    }

}
