package com.kaishengit.service;

public class MyAdvices {


    public void beforeAdvice() {
        System.out.println("前置通知2...");
    }

    public void afterRetuingAdvice(Object result) {
        System.out.println("后置通知...result:" + result);
    }

    public void throwingAdvice(Exception ex) {
        System.out.println("异常通知...msg:" + ex.getMessage());
    }

    public void afterAdvice() {
        System.out.println("最终通知");
    }


}
