package com.ly.zmn48644.session;

import com.ly.zmn48644.binding.MapperRegistry;

/**
 * 全局配置中心
 */
public class Configuration {

    private MapperRegistry mapperRegistry = new MapperRegistry();

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type);
    }
}
