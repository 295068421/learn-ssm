package com.kaishengit.test;

import com.kaishengit.pojo.Task;
import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.LockOptions;
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
        task.setTitle("hello,task");

        session.save(task);

        session.getTransaction().commit();
    }

    @Test
    public void findByUUid() throws InterruptedException {
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();

        final Task task = (Task) session.get(Task.class,"8a8082e454bc3f1b0154bc3f1f6a0000",LockOptions.UPGRADE);
        task.setTitle("333");

        Thread thread = new Thread(new Runnable() {
            public void run() {
                Session session2 = HibernateUtil.getSession();
                session2.beginTransaction();

                Task task2 = (Task) session2.get(Task.class,"8a8082e454bc3f1b0154bc3f1f6a0000");
                task2.setTitle("444");

                session2.getTransaction().commit();
            }
        });

        thread.start();

        Thread.sleep(2000);



        session.getTransaction().commit();
    }

}
