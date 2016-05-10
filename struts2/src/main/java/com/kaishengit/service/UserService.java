package com.kaishengit.service;

import com.kaishengit.dao.UserDao;
import com.kaishengit.pojo.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public User login(User user) {
        User dbUser = userDao.findByUserName(user.getUsername());
        if(dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return dbUser;
        } else {
            throw new RuntimeException("账号或密码错误");
        }
    }
}
