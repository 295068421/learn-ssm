package com.kaishengit.dao.impl;

import com.kaishengit.dao.UserDao;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
        //System.out.println("create UserDao ....");
    }


    public void init() {
        System.out.println("UserDao init....");
    }

    public void destroy() {
        System.out.println("userDao destroy....");
    }

    public void save() {
        System.out.println("UserDao save.....");
    }
}
