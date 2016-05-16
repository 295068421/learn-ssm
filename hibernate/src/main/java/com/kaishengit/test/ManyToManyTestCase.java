package com.kaishengit.test;

import com.kaishengit.pojo.Student;
import com.kaishengit.pojo.Teacher;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ManyToManyTestCase {

    @Test
    public void testFind() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        /*Student student = (Student) session.get(Student.class,11);
        System.out.println(student.getStuname());

        Set<Teacher> teacherSet = student.getTeachers();
        for(Teacher teacher : teacherSet) {
            System.out.println(teacher.getId() + " -> " + teacher.getTeaname());
        }*/

        Teacher teacher = (Teacher) session.get(Teacher.class,13);
        System.out.println(teacher.getTeaname());

        //teacher.getStudentSet().size();
        Hibernate.initialize(teacher.getStudentSet());


        session.getTransaction().commit();

        /*Set<Student> studentSet = teacher.getStudentSet();
        for(Student student : studentSet) {
            System.out.println(student.getId() + " -> " + student.getStuname());
        }*/

    }


    @Test
    public void testSave() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Student student = new Student();
        student.setStuname("S-1");

        Student student2 = new Student();
        student2.setStuname("S-2");

        Teacher teacher = new Teacher();
        teacher.setTeaname("T-1");

        Teacher teacher2 = new Teacher();
        teacher2.setTeaname("T-2");

        Set<Teacher> teachers = new HashSet<Teacher>();
        teachers.add(teacher);
        teachers.add(teacher2);

        student.setTeachers(teachers);
        student2.setTeachers(teachers);


        session.save(teacher);
        session.save(teacher2);

        session.save(student);
        session.save(student2);



        session.getTransaction().commit();
    }













}
