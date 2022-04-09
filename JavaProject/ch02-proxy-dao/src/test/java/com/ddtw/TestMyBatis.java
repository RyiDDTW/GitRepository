package com.ddtw;

import com.ddtw.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    @Test
    public void TestInsert() throws IOException {

        //访问mybatis读取数据库数据
        //1.定义mybatis主配置文件的名称
        String config = "mybatis-config.xml";
        //2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建了SqlSessionFactorBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.【重要】获取SqkSession对象，从SqlSessionFactory中获取SqkSession
        SqlSession sqlSession =factory.openSession(true);
        //6.【重要】指定要执行的语句。sql映射文件汇总namespace + "." +标签的id值
        String sqlId = "com.ddtw.dao.StudentDao" + "." + "insertStudent";
        //7.执行sql语句，通过sqlId找到语句
        Student student = new Student(1004,"张三","zhangsan@163.com",22);
        int num = sqlSession.insert(sqlId,student);

        //sqlSession.commit();
        //8.输出结果
        System.out.println("执行后插入了" + num + "条数据!");
        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
