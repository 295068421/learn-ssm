package com.kaishengit.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class HomeAction extends BaseAction {

    private String state;

    @Override
    public String execute() throws Exception {
        System.out.println("Hello,Struts2");
        return ERROR;
    }

    @Action(value = "save",results = {
            @Result(name = "success",type = "redirectAction",
                    params = {"actionName","home","namespace","/book","state","${state}"}),
            @Result(name = "error",type = "redirectAction",
                    params = {"actionName","home","namespace","/book","state","${state}"})
    })
    public String save() {
        System.out.println("save method....");
        if(1!=1) {
            state = "10009";
            return SUCCESS;
        } else {
            state = "20009";
            return ERROR;
        }
    }

    //get set

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
