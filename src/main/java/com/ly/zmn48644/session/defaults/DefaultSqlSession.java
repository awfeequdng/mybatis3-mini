package com.ly.zmn48644.session.defaults;

import com.ly.zmn48644.mapping.MappedStatement;
import com.ly.zmn48644.session.Configuration;
import com.ly.zmn48644.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * SqlSession的默认实现类
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;


    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public <T> T selectOne(String statement) {
        //调用 selectList 方法

        return null;
    }

    @Override
    public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
        return null;
    }

    @Override
    public <E> List<E> selectList(String statement) {

        MappedStatement ms = configuration.getMappedStatement(statement);
        //调用执行器完成查询操作

        return new ArrayList<>();
    }

    //这里返回的是指定接口的代理对象
    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
