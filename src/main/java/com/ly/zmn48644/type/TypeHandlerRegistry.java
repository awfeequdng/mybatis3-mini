package com.ly.zmn48644.type;

import com.ly.zmn48644.type.impl.IntegerTypeHandler;
import com.ly.zmn48644.type.impl.StringTypeHandler;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类型转换器注册中心
 */
public final class TypeHandlerRegistry {
    private final Map<Type, Map<JdbcType, TypeHandler<?>>> TYPE_HANDLER_MAP = new ConcurrentHashMap<>();
    private final Map<Class<?>, TypeHandler<?>> ALL_TYPE_HANDLERS_MAP = new HashMap<Class<?>, TypeHandler<?>>();

    //注册基本的类型转换器
    public TypeHandlerRegistry() {
        register(Integer.class, new IntegerTypeHandler());
        register(int.class, new IntegerTypeHandler());
        register(String.class, new StringTypeHandler());
    }

    public void register(Class<?> javaType, TypeHandler typeHandler) {
        register(javaType, null, typeHandler);
    }

    private void register(Type javaType, JdbcType jdbcType, TypeHandler<?> handler) {
        if (javaType != null) {
            Map<JdbcType, TypeHandler<?>> map = TYPE_HANDLER_MAP.get(javaType);
            if (map == null) {
                map = new HashMap<JdbcType, TypeHandler<?>>();
                TYPE_HANDLER_MAP.put(javaType, map);
            }
            map.put(jdbcType, handler);
        }
        ALL_TYPE_HANDLERS_MAP.put(handler.getClass(), handler);
    }

    /**
     * 根据属性类型,和jdbc数据
     *
     * @param propertyType
     * @param jdbcType
     * @return
     */
    public TypeHandler<?> getTypeHandler(Class<?> propertyType, JdbcType jdbcType) {

        Map<JdbcType, TypeHandler<?>> jdbcTypeTypeHandlerMap = TYPE_HANDLER_MAP.get(propertyType);

        return jdbcTypeTypeHandlerMap.get(jdbcType);
    }
}
