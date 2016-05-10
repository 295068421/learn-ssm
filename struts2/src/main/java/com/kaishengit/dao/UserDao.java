package com.kaishengit.dao;

import com.kaishengit.pojo.User;
import com.kaishengit.util.DBHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDao {

    public User findByUserName(String username) {
        String sql = "select * from t_user where username = ?";
        return DBHelp.query(sql,new BeanHandler<>(User.class),username);
    }

}
