package com.kaishengit.action;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseAction {

    public HttpServletRequest getHttpRequest() {
        return ServletActionContext.getRequest();
    }
}
