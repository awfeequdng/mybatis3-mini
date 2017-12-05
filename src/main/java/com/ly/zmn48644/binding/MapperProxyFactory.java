package com.ly.zmn48644.binding;


import java.lang.reflect.Proxy;

public class MapperProxyFactory {


    public  <T> T newInstance(MapperProxy proxy, Class<T>[] mapperInterface) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), mapperInterface, proxy);
    }
}
