package com.kaishengit.test;

import com.kaishengit.mapper.NodeMapper;
import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.mapper.TopicMapper;
import com.kaishengit.pojo.Node;
import com.kaishengit.pojo.Student;
import com.kaishengit.pojo.Topic;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

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

    public void testUpdate() {
        SqlSession session = sessionFactory.openSession();

        Student student = new Student();
        student.setId(28);
        student.setStuname("Java");
        student.setStuage(23);

        session.update("com.kaishengit.mapper.StudentMapper.update",student);

        session.commit();
        session.close();
    }

    public void testDel() {
        SqlSession session = sessionFactory.openSession();
        session.delete("com.kaishengit.mapper.StudentMapper.del",28);
        session.commit();
        session.close();
    }

    public void testFindById() {
        SqlSession session = sessionFactory.openSession();

        Student student = session.selectOne("com.kaishengit.mapper.StudentMapper.findById",29);
        System.out.println(student.getStuname() + "\t" + student.getStuage());

        session.commit();
        session.close();
        assertNotNull(student);
    }

    public void testFindAll() {
        SqlSession session = sessionFactory.openSession();

        List<Student> studentList = session.selectList("com.kaishengit.mapper.StudentMapper.findAll");

        for(Student stu : studentList) {
            System.out.println(stu.getStuname() + " \t " + stu.getStuage());
        }

        session.commit();
        session.close();

        assertNotNull(studentList);
        assertEquals(studentList.size(),4);

    }

    public void testSaveWithInterface() {
        SqlSession session = sessionFactory.openSession();

        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setStuname("李四");
        student.setStuage(26);

        studentMapper.save(student);

        session.commit();
        session.close();

    }

    public void testUpdateWithInterface() {
        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.findById(29);

        student.setStuage(30);
        mapper.update(student);

        session.commit();
        session.close();


    }

    public void testTopicFindById() {
        SqlSession session = sessionFactory.openSession();

        TopicMapper mapper = session.getMapper(TopicMapper.class);
        Topic topic = mapper.findById(1);

        System.out.println(topic.getTitle());
        System.out.println("------------------");
        System.out.println(topic.getUser().getUsername());
        System.out.println(topic.getNode().getNodename());

        session.commit();
        session.close();

    }

    public void testNodeFindById() {
        SqlSession session = sessionFactory.openSession();

        NodeMapper nodeMapper = session.getMapper(NodeMapper.class);
        Node node = nodeMapper.findById(1);

        System.out.println(node.getNodename());
        System.out.println("-----------------------");
        List<Topic> topics = node.getTopicList();

        for(Topic topic : topics) {
            System.out.println(topic.getTitle());
        }

        session.commit();
        session.close();

    }
}
