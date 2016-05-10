package com.kaishengit.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public abstract class BaseAction extends ActionSupport {

    public HttpServletRequest getHttpRequest() {
        return ServletActionContext.getRequest();
    }

    public HttpServletResponse getHttpResponse() {
        return ServletActionContext.getResponse();
    }

    public Map<String,Object> getSession() {
        return ActionContext.getContext().getSession();
    }

    public void putSession(String key,Object value) {
        getSession().put(key,value);
    }

    public void renderJSON(Object obj) throws IOException {
        String json = new Gson().toJson(obj);

        HttpServletResponse response = getHttpResponse();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }



}
