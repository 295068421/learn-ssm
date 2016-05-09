package com.kaishengit.action;

import com.google.common.collect.Lists;
import com.kaishengit.pojo.User;

import java.util.List;

public class UserAction {

    private User user;
    private List<User> userList;


    public String list() {

        User u1 = new User();
        u1.setName("U1");
        User u2 = new User();
        u2.setName("U2");

        userList = Lists.newArrayList(u1,u2);
        return "success";
    }

    public String add() {
        return "success";
    }

    public String save() {
        System.out.println("Name:" + user.getName() + " Phone:" + user.getPhone());
        return "success";
    }

    //get set

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
