package com.ly.zmn48644;

import com.ly.zmn48644.io.Resources;
import com.ly.zmn48644.mapper.UserMapper;
import com.ly.zmn48644.session.SqlSession;
import com.ly.zmn48644.session.SqlSessionFactory;
import com.ly.zmn48644.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionTest {

    public static void main(String[] args) {

        InputStream inputStream = Resources.getResourcesAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(mapper.getUserCountByName("zmn"));


    }
}
