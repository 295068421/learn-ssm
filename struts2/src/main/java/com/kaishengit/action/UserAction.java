package com.kaishengit.action;

import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;

public class UserAction extends BaseAction {

    private UserService userService = new UserService();

    private User user;



    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String login() {
        try {
            User dbUser = userService.login(user);
            putSession("curr_user",dbUser);
            return SUCCESS;
        }catch (RuntimeException ex) {
            return ERROR;
        }
    }

    //get set

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
