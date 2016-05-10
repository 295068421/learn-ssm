package com.kaishengit.action;

import com.google.common.collect.Lists;
import com.kaishengit.pojo.User;

import java.util.List;

public class JsonAction extends BaseAction {

    private String name;
    private User user;
    private List<String> addresses;


    @Override
    public String execute() throws Exception {
        name = "Jack";

        user = new User();
        user.setId(101);
        user.setUsername("中文名字");
        //user.setPassword("123123");

        addresses = Lists.newArrayList("China","USA");

        return SUCCESS;
    }

    //get set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
}
