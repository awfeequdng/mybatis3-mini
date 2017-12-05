package com.ly.zmn48644.build.xml;

import com.ly.zmn48644.build.BaseBuilder;
import com.ly.zmn48644.parsing.XNode;
import com.ly.zmn48644.parsing.XPathParser;
import com.ly.zmn48644.session.Configuration;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder extends BaseBuilder {
    private String resource;

    private XPathParser parser;

    public XMLMapperBuilder(String resource, InputStream inputStream, Configuration configuration) {
        super(configuration);
        this.resource = resource;
        this.parser = new XPathParser(inputStream);
    }

    public void parse() {

        configurationElement(parser.evalNode("/mapper"));

    }

    private void configurationElement(XNode context) {
        //目前这里只解析 select|update|delete|insert 配置
        buildStatementFromContext(context.evalNodes("select|insert|update|delete"));
    }

    /**
     * 解析映射配置文件中的 select,insert,update,delete元素,生成对应的
     *
     * @param context
     */
    private void buildStatementFromContext(List<XNode> context) {

        for (XNode child : context) {
            XMLStatementBuilder xmlStatementBuilder = new XMLStatementBuilder(configuration, child);
            xmlStatementBuilder.parseStatementNode();
        }

    }
}
