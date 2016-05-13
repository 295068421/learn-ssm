package com.kaishengit.test;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.junit.Test;

import java.util.List;

public class CriteriaTestCase {

    @Test
    public void testFinaAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
        List<User> userList = criteria.list();

        for(User user : userList) {
            System.out.println(user.getUsername() + " -> " + user.getId());
        }

        session.getTransaction().commit();
    }

    @Test
    public void testFinaBy() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        //where username in (s1,xyz)
        Criteria criteria = session.createCriteria(User.class);

        Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(Restrictions.eq("username","S1"));
        disjunction.add(Restrictions.eq("username","xyz"));

        criteria.add(disjunction);

        //criteria.add(Restrictions.like("username","S", MatchMode.ANYWHERE));

        //criteria.add(Restrictions.like("username","S%"));

        //criteria.add(Restrictions.in("username",new String[]{"S1","xyz"}));
        //criteria.add(Restrictions.or(Restrictions.eq("username","S1"),Restrictions.eq("username","xyz")));


        //criteria.add(Restrictions.eq("username","S1"));
        //criteria.add(Restrictions.eq("password","234"));

        //criteria.addOrder(Order.desc("id"));

        //criteria.setFirstResult(5);
        //criteria.setMaxResults(5);

        List<User> userList = criteria.list();

        for(User user : userList) {
            System.out.println(user.getUsername() + " -> " + user.getId());
        }

        session.getTransaction().commit();
    }

    @Test
    public void testCount() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.rowCount());
        projectionList.add(Projections.max("id"));

        criteria.setProjection(projectionList);

        //criteria.setProjection(Projections.rowCount()); // count(*) count(id)
        //criteria.setProjection(Projections.max("id"));

        Object[] obj = (Object[]) criteria.uniqueResult();
        System.out.println(obj[0] + " : " + obj[1]);



        session.getTransaction().commit();
    }


}
