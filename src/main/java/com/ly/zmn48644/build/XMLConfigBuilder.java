package com.ly.zmn48644.build;

import com.ly.zmn48644.build.xml.XMLMapperBuilder;
import com.ly.zmn48644.io.Resources;
import com.ly.zmn48644.parsing.XNode;
import com.ly.zmn48644.parsing.XPathParser;
import com.ly.zmn48644.session.Configuration;

import java.io.IOException;
import java.io.InputStream;

public class XMLConfigBuilder extends BaseBuilder {

    private XPathParser parser;

    public XMLConfigBuilder(InputStream inputStream) {
        //在这里创建全局配置对象
        super(new Configuration());
        //创建XPathParser对象用于解析XML
        parser = new XPathParser(inputStream);
    }

    public Configuration parse() {

        //解析mappers节点
        parseConfiguration(parser.evalNode("/configuration"));

        return this.configuration;
    }

    private void parseConfiguration(XNode root) {

        mapperElement(root.evalNode("mappers"));
    }

    /**
     * 解析mappers节点的配置
     *
     * @param parent 对应 配置文件中的mappers节点
     */
    private void mapperElement(XNode parent) {

        for (XNode child : parent.getChildren()) {

            String resource = child.getStringAttribute("resource");
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                //通过 XMLMapperBuilder 调用 parse 方法对xml进行处理解析映射配置文件
                XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(resource, inputStream, configuration);
                xmlMapperBuilder.parse();

            } catch (IOException e) {
                throw new RuntimeException("resource 指向的资源不存在或者未指定!");
            }

        }

    }
}
