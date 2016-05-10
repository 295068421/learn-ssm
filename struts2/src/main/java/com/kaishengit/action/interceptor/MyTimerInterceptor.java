package com.kaishengit.action.interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTimerInterceptor extends AbstractInterceptor {

    private Logger logger = LoggerFactory.getLogger(MyTimerInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        ActionProxy proxy = invocation.getProxy(); //请求的目标对象的代理对象

        String actionName = proxy.getActionName(); //获取xml文件中Action节点中name属性的名字
        logger.info("ActionName:{}",actionName);
        String methodName = proxy.getMethod(); // 目标对象中业务方法的名字
        logger.info("MethodName:{}",methodName);
        String namespace = proxy.getNamespace(); //获取namespace
        logger.info("NameSpace:{}",namespace);

        long start = System.currentTimeMillis();
        String result = proxy.execute(); // 目标对象的业务方法的执行
        long end = System.currentTimeMillis();

        logger.info("耗时{}毫秒",(end-start));

        return result;
    }


}
