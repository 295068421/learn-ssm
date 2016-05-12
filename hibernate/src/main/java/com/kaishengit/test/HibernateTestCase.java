package com.kaishengit.test;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HibernateTestCase {

    @Test
    public void testHelloWorld() {
        // 创建SessionFactory
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        // 创建Session
        Session session = sessionFactory.getCurrentSession();
        //开启事务
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUsername("Hibernate4.3.1");
        user.setPassword("hello,world");

        session.save(user);


        //结束事务
        transaction.commit();
        //transaction.rollback();
        //session.getTransaction().commit();
        //session.getTransaction().rollback();
    }


    @Test
    public void testFindById() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,22);
        System.out.println(user.getUsername());

        session.getTransaction().commit();
        Assert.assertNotNull(user);
    }

    @Test
    public void testDel() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,22);
        session.delete(user);

        session.getTransaction().commit();
    }

    @Test
    public void testUpdate() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,23);
        user.setUsername("rose");

        session.getTransaction().commit();
    }

    @Test
    public void testFindAll() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        //hql
        String hql = "from User where username = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,"xxx");

        User user = (User) query.uniqueResult();
        System.out.println(user.getId() + " -> " + user.getUsername());

        /*List<User> userList = query.list();

        for(User user : userList) {
            System.out.println(user.getId() + " -> " + user.getUsername());
        }*/


        session.getTransaction().commit();


    }





}
