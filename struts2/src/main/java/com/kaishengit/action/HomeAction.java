package com.kaishengit.action;

public class HomeAction {

    public String execute() throws Exception {
        System.out.println("Hello,Struts2");
        return "success";
    }

    public String add() {
        System.out.println("HomeAction add method");
        return "success";
    }

}
