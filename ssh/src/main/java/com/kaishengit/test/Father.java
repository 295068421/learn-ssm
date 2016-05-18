package com.kaishengit.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class Father<T,PK> {

    public Father() {
        Class clazz = this.getClass(); // son
        ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass(); //father<String,Integer>
        Type[] argumentTypes = type.getActualTypeArguments();
        Class argumentClass = (Class) argumentTypes[0];
    }
}
