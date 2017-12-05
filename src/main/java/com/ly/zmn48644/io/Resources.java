package com.ly.zmn48644.io;

import java.io.InputStream;

public class Resources {

    public static InputStream getResourcesAsStream(String resource) {
        //TODO 资源加载模块需要持续改进
        return Resources.class.getClassLoader().getResourceAsStream(resource);
    }
}
