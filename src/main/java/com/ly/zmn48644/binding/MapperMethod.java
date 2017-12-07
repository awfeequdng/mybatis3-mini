package com.ly.zmn48644.binding;

import com.ly.zmn48644.session.Configuration;
import com.ly.zmn48644.session.SqlSession;

import java.lang.reflect.Method;

/**
 * 接口中的一个方法也就是,一个Method对象对应一个MapperMethod
 * 当调用接口中的方法时,通过动态代理调用 MapperMethod 的 execute 方法.
 */
public class MapperMethod {
    private final SqlCommand sqlCommand;

    public MapperMethod(Configuration configuration, Class<?> mapperInterface, Method method) {
        //这里初始化当前对象的 SqlCommand 属性
        this.sqlCommand = new SqlCommand(configuration, mapperInterface, method);
    }

    public Object execute(SqlSession sqlSession) {

        //在这里调用SqlSession中相对应的方法比如update,delete,select等方法.
        switch (sqlCommand.getType()) {
            case SELECT: {
                //接口方法返回void

                //接口方法返回集合或者数组

                //接口方法返回map

                //接口返回单个对象
                sqlSession.selectList(sqlCommand.getName());

                break;
            }
            case UPDATE: {
                System.out.println("执行更新操作!");
                break;
            }
            case DELETE: {
                System.out.println("执行删除操作");
                break;
            }
            case INSERT: {
                System.out.println("执行插入操作");
            }
            default:
                throw new RuntimeException();
        }

        return Integer.valueOf(1);
    }
}
