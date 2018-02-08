package com.ly.zmn48644.type;

import com.ly.zmn48644.type.impl.IntegerTypeHandler;
import com.ly.zmn48644.type.impl.StringTypeHandler;

/**
 * 类型转换器注册中心
 */
public final class TypeHandlerRegistry {

    //注册基本的类型转换器
    public TypeHandlerRegistry() {
        register(Integer.class, new IntegerTypeHandler());
        register(int.class, new IntegerTypeHandler());
        register(String.class, new StringTypeHandler());
    }

    public void register(Class<?> javaType, TypeHandler typeHandler) {

    }

    /**
     * 根据属性类型,和jdbc数据
     * @param propertyType
     * @param jdbcType
     * @return
     */
    public TypeHandler<?> getTypeHandler(Class<?> propertyType, JdbcType jdbcType) {

        return null;
    }
}
