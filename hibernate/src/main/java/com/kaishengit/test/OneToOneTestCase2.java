package com.kaishengit.test;

import com.kaishengit.pojo.Topic;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

public class OneToOneTestCase2 {

    @Test
    public void testFind() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Topic topic = (Topic) session.get(Topic.class,1);
        System.out.println(topic.getTitle());
        System.out.println(topic.getTopicContent().getContent());

        session.getTransaction().commit();
    }

}
