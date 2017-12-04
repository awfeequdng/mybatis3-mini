package com.ly.zmn48644.session.defaults;

import com.ly.zmn48644.binding.MapperProxy;
import com.ly.zmn48644.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * SqlSession的默认实现类
 */
public class DefaultSqlSession implements SqlSession {

    //这里返回的是指定接口的代理对象
    @Override
    public <T> T getMapper(Class<T> type) {
        MapperProxy proxy = new MapperProxy();
        Class<T>[] classes = new Class[]{type};
        return newInstance(proxy, classes);
    }

    private <T> T newInstance(MapperProxy proxy, Class<T>[] mapperInterface) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), mapperInterface, proxy);
    }
}
