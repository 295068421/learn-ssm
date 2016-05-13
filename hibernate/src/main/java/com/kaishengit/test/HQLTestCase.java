package com.kaishengit.test;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class HQLTestCase {

    @Test
    public void testFindAll() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "from User";

        Query query = session.createQuery(hql);
        //limit 0,5
        query.setFirstResult(15);
        query.setMaxResults(5);
        //query.setParameter("name","S1");
        //query.setString("name","S1");
        //query.setString(0,"S1");

        List<User> userList = query.list();

        for(User user : userList) {
            System.out.println(user.getId() + " -> " + user.getUsername());
        }

        session.getTransaction().commit();

    }

    @Test
    public void testFind() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "select username from User";
        Query query = session.createQuery(hql);
        List<String> result = query.list();

        for(String name : result) {
            System.out.println(name);
        }


        session.getTransaction().commit();
    }

    @Test
    public void testFind2() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "select id,username,password from User";
        Query query = session.createQuery(hql);
        List<Object[]> result = query.list();

        for(Object[] array : result) {
            System.out.println(array[0] + " -> " + array[1] + " -> " + array[2]);
        }


        session.getTransaction().commit();
    }

    @Test
    public void testTotal() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "select count(*),max(id),min(id) from User";
        Query query = session.createQuery(hql);
        Object[] objects = (Object[]) query.uniqueResult();

        System.out.println(objects[0] + " : " + objects[1] + " : " + objects[2]);

        session.getTransaction().commit();
    }

}
