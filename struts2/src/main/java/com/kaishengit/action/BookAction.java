package com.kaishengit.action;

import com.google.common.collect.Lists;
import com.kaishengit.pojo.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import java.util.List;

@Namespace("/book")
public class BookAction extends BaseAction {

    private String username;
    private List<User> userList;

    @Action("home")
    @Override
    public String execute() throws Exception {
        username = "tom2";
        System.out.println("book home method.....");

        User u1 = new User();
        u1.setId(101);
        u1.setUsername("Rose");

        User u2 = new User();
        u2.setId(201);
        u2.setUsername("Hanks");

        userList = Lists.newArrayList(u1,u2);

        return SUCCESS;
    }

    //get set
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
