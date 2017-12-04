package com.ly.zmn48644.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 此类是Mapper接口的具体代理类
 * 所有调用mapper接口的方法都会被此类拦截
 * 此处应用的是动态代理,具体通过JDK提供的动态代理机制实现.
 */
public class MapperProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象被调用");

        return 1;
    }
}
