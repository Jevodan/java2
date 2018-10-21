package ru.jevo.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

abstract class AbstractDataService {

    private static final String RESOURCE = "SqlMapConfig.xml";

    final SqlSessionFactory sqlSessionFactory;

    final SqlSession sqlSession;

    /**
     * Получаем ресурс в виде потока,
     * Благодаря ресурсу получаем коннекшион
     */
    public AbstractDataService() throws IOException {
        final InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
}
