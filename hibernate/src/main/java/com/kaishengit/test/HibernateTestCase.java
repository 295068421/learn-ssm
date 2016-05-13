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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testGet() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,224);
        //System.out.println(user.getUsername());


        session.getTransaction().commit();

        Assert.assertNull(user);
    }

    @Test
    public void testLoad() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        //1.懒加载
        //2.无论ID是否有对应的对象，结果始终不为null,在第一次使用的时候，如果对象不存在，
        //则抛出org.hibernate.ObjectNotFoundException 异常
        //3.如果在session关闭后，去第一次调用持久化对象，会引起org.hibernate.LazyInitializationException异常
        User user = (User) session.load(User.class,224);
        //System.out.println(user.getUsername());

        session.getTransaction().commit();

        //System.out.println(user.getUsername());
    }


    @Test
    public void testAdd() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = new User();
        user.setUsername("zzzz");
        user.setPassword("123123");

        //Integer id = (Integer) session.save(user);
        //System.out.println(id);
        //session.save(user);
        //System.out.println("ID:" + user.getId());

        session.persist(user);
        System.out.println("ID:" + user.getId());


        session.getTransaction().commit();
    }


    @Test
    public void testEdit() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,25);

        session.getTransaction().commit();

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        user.setUsername("xyz");
        session2.update(user);

        session2.getTransaction().commit();



    }

    @Test
    public void testSaveOrUpdate() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = new User();
        user.setUsername("S1");
        user.setPassword("123");

        session.saveOrUpdate(user); //save

        session.getTransaction().commit();

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        user.setUsername("xyz");
        session2.saveOrUpdate(user); // update

        session2.getTransaction().commit();
    }


    @Test
    public void testMerge() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = new User();
        user.setId(224);
        user.setUsername("S1");
        user.setPassword("123");

        session.merge(user);

        //User user = (User) session.get(User.class,18);

        session.getTransaction().commit();

       /* Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        user.setUsername("vvvvv");
        session2.merge(user);

        session2.getTransaction().commit();*/
    }


    @Test
    public void testClear() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,18);
        session.clear();
        user.setPassword("1231111");

        session.getTransaction().commit();
    }

    @Test
    public void testFlush() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,18);
        user.setPassword("0987654");
        session.flush();

        session.getTransaction().commit();
    }

    @Test
    public void testSaveMap() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("username","tom");
        map.put("password","889900");

        session.save("userMap",map);

        session.getTransaction().commit();
    }

    @Test
    public void testDynamic() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        /*User user = new User();
        user.setUsername("zzz");

        session.save(user);*/

        User user = (User) session.get(User.class,18);
        user.setPassword("0987654");


        session.getTransaction().commit();
    }




}
