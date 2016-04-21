package com.kaishengit.service.impl;

import com.kaishengit.dao.UserDao;
import com.kaishengit.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setMyUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println("--------------------");
        userDao.save();
        System.out.println("--------------------");
    }
}
