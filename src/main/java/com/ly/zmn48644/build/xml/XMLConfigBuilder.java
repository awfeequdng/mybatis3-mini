package com.ly.zmn48644.build.xml;

import com.ly.zmn48644.session.Configuration;

import java.io.InputStream;

public class XMLConfigBuilder {
    protected final Configuration configuration;


    public XMLConfigBuilder(InputStream inputStream) {
        this.configuration = new Configuration();

    }

    public Configuration parse() {

        //解析mappers节点


        return this.configuration;
    }
}
