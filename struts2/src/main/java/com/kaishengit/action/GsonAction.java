package com.kaishengit.action;

import com.kaishengit.pojo.User;

public class GsonAction extends BaseAction {

    public String toJson() throws Exception {

        System.out.println("toJSON....................");

        User user = new User();
        user.setId(101);
        user.setUsername("张三丰");
        user.setPassword("123123");

        renderJSON(user);

        return NONE;
    }
}
