package com.ly.zmn48644;

import com.ly.zmn48644.mapper.UserMapper;
import com.ly.zmn48644.session.SqlSession;
import com.ly.zmn48644.session.SqlSessionFactory;
import com.ly.zmn48644.session.SqlSessionFactoryBuilder;

public class SqlSessionTest {

    public static void main(String[] args) {

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(mapper.getUserCountByName("zmn"));


    }
}
