package com.kaishengit.action.interceptor;

import com.kaishengit.pojo.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        ActionProxy proxy = invocation.getProxy();

        String namespace = proxy.getNamespace();
        String actionName = proxy.getActionName();

        if("/user".equals(namespace) && ("login".equals(actionName) || "lg".equals(actionName))) {
            return proxy.execute();
        } else {
            Map<String,Object> session = ActionContext.getContext().getSession();
            User user = (User) session.get("curr_user");
            if(user == null) {
                return Action.LOGIN;
            } else {
                return proxy.execute();
            }
        }
    }
}
