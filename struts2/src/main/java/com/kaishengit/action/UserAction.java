package com.kaishengit.action;

import com.google.common.collect.Lists;
import com.kaishengit.pojo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class UserAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware,ApplicationAware,ServletContextAware {

    private User user;
    private List<User> userList;
    private String state;
    private Map<String, Object> session;
    private HttpServletRequest request;
    private HttpServletResponse response;


    public String list() {

        System.out.println("list method....");
        User u1 = new User();
        u1.setName("U1");
        User u2 = new User();
        u2.setName("U2");

        /*Map<String,Object> sessionMap = ActionContext.getContext().getSession();
        sessionMap.put("sKey","Struts2");*/
        session.put("skey2","SpringMVC");

        Map<String,Object> applicationMap = ActionContext.getContext().getApplication();




        /*HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpSession session = request.getSession();
        ServletContext application = session.getServletContext();*/


        userList = Lists.newArrayList(u1,u2);
        return SUCCESS;
    }

    public String add() {
        System.out.println("add method....");
        return SUCCESS;
    }

    /*@Override
    public void validate() {
        System.out.println("validate........");
    }*/

    public void validateSave() {
        System.out.println("validate Save .....");

        if(user == null || StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPhone())) {
            System.out.println("input input.....");
            state = "10045";
            addActionError("请输入姓名或电话");
        }
    }

    public String save() {
        System.out.println("Name:" + user.getName() + " Phone:" + user.getPhone());
        return SUCCESS;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {

    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {

    }

    @Override
    public void setApplication(Map<String, Object> map) {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {

    }
}
