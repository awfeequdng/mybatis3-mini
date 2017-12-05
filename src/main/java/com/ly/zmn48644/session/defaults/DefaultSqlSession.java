package com.ly.zmn48644.session.defaults;

import com.ly.zmn48644.session.Configuration;
import com.ly.zmn48644.session.SqlSession;

/**
 * SqlSession的默认实现类
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    //这里返回的是指定接口的代理对象
    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type);
    }

}
