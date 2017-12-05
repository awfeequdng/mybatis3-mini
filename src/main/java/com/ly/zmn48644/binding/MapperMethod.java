package com.ly.zmn48644.binding;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 接口中的一个方法也就是,一个Method对象对应一个MapperMethod
 * 当调用接口中的方法时,通过动态代理调用 MapperMethod 的 execute 方法.
 */
public class MapperMethod {
    private final SqlCommand sqlCommand;

    public MapperMethod() {
        //这里初始化当前对象的 SqlCommand 属性
        this.sqlCommand = new SqlCommand();
        //TODO 这里先临时写为固定的type和name
        //随后完善从配置文件中读取的功能.
        this.sqlCommand.setName("getUserCountByName");
        this.sqlCommand.setType("SELECT");

    }

    public Object execute() {

        //在这里调用SqlSession中相对应的方法比如update,delete,select等方法.
        switch (sqlCommand.getType()) {
            case "SELECT": {
                System.out.println("执行查询操作!");
                break;
            }
            case "UPDATE":{
                System.out.println("执行更新操作!");
                break;
            }
            case "DELETE":{
                System.out.println("执行删除操作");
                break;
            }
            case "INSERT" :{
                System.out.println("执行插入操作");
            }
            default:
                throw new RuntimeException();
        }


        return Integer.valueOf(1);
    }
}
