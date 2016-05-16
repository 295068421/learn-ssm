package com.kaishengit.test;

import com.kaishengit.pojo.Task;
import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

public class HibernateTestCase {

    @Test
    public void testFind() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        User user = (User) session.get(User.class,18);
        System.out.println(user.getUsername());

        session.getTransaction().commit();


        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        User user2 = (User) session2.get(User.class,18);
        System.out.println(user2.getUsername());

        session2.getTransaction().commit();

    }

    @Test
    public void testUuid() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Task task = new Task();
        task.setTitle("hehe");

        session.save(task);

        session.getTransaction().commit();
    }

}
