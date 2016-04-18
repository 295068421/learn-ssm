package com.kaishengit.test;

import com.kaishengit.pojo.Student;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisTestCase extends TestCase {

    private SqlSessionFactory sessionFactory;

    @Override
    protected void setUp() throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public void testBuilderSQLSessionFactory () throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        assertNotNull(sessionFactory);
    }

    public void testSave() {
        SqlSession session = sessionFactory.openSession();

        Student student = new Student();
        student.setStuname("MyBatis3");
        student.setStuage(3);

        session.insert("com.kaishengit.mapper.StudentMapper.save",student);

        session.commit(); //!!! 事务要提交或回滚
        session.close();
    }

}
