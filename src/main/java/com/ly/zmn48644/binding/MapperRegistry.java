package com.ly.zmn48644.binding;

import com.ly.zmn48644.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * 映射接口注册中心.
 */
public class MapperRegistry {

    /**
     * 缓存接口类
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<Class<?>, MapperProxyFactory<?>>();

    /**
     * 从注册中心获取映射接口实例
     *
     * @param type
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            mapperProxyFactory = new MapperProxyFactory<>();
        }
        MapperProxy proxy = new MapperProxy(sqlSession, type);
        Class<T>[] classes = new Class[]{type};
        return mapperProxyFactory.newInstance(proxy, classes);
    }

    /**
     * 向注册中心注册一个映射接口
     */
    public <T> void addMapper(Class<T> type) {
        MapperProxyFactory<T> mapperProxyFactory = new MapperProxyFactory<>();
        knownMappers.put(type, mapperProxyFactory);
    }
}
