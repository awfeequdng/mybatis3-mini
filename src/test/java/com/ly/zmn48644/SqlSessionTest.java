package com.ly.zmn48644;

import com.ly.zmn48644.io.Resources;
import com.ly.zmn48644.mapper.AuthorMapper;
import com.ly.zmn48644.model.Author;
import com.ly.zmn48644.session.SqlSession;
import com.ly.zmn48644.session.SqlSessionFactory;
import com.ly.zmn48644.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionTest {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);

        Author author = mapper.selectAuthorById(1);
        System.out.println(author.toString());


    }
}
