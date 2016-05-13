package com.kaishengit.test;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class NativeSQLTestCase {

    @Test
    public void findAll() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String sql = "select id,username,password from t_user ORDER by id desc";
        SQLQuery query = session.createSQLQuery(sql).addEntity(User.class);

        /*List<Object[]> result = query.list();

        for(Object[] array : result) {
            System.out.println(array[0] + " -> " + array[1]);
        }*/

        List<User> userList = query.list();

        for(User user : userList) {
            System.out.println(user.getId() + " -> " + user.getUsername());
        }


        session.getTransaction().commit();


    }


}
