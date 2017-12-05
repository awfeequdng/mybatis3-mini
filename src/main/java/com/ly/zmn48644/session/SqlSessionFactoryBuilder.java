package com.ly.zmn48644.session;

import com.ly.zmn48644.build.xml.XMLConfigBuilder;
import com.ly.zmn48644.session.defaults.DefaultSqlSessionFactory;

public class SqlSessionFactoryBuilder {


    public static SqlSessionFactory build() {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        return build(xmlConfigBuilder.parse());
    }

    public static SqlSessionFactory build(Configuration configuration) {
        return new DefaultSqlSessionFactory(configuration);
    }
}
