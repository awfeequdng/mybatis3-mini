package com.ly.zmn48644.session;

import com.ly.zmn48644.session.defaults.DefaultSqlSession;
import com.ly.zmn48644.session.mapper.UserMapper;

public class SqlSessionTest {

    public static void main(String[] args) {

        SqlSession sqlSession = new DefaultSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(mapper.getUserCountByName("zmn"));

    }
}
