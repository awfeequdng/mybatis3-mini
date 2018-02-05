package com.ly.zmn48644.build.xml;

import com.ly.zmn48644.build.BaseBuilder;
import com.ly.zmn48644.build.MapperBuilderAssistant;
import com.ly.zmn48644.build.StaticSqlSource;
import com.ly.zmn48644.mapping.MappedStatement;
import com.ly.zmn48644.mapping.SqlCommandType;
import com.ly.zmn48644.mapping.SqlSource;
import com.ly.zmn48644.parsing.XNode;
import com.ly.zmn48644.session.Configuration;

import java.util.Locale;

public class XMLStatementBuilder extends BaseBuilder {
    private XNode context;
    private MapperBuilderAssistant builderAssistant;

    public XMLStatementBuilder(Configuration configuration, MapperBuilderAssistant builderAssistant, XNode context) {
        super(configuration);
        this.context = context;
        this.builderAssistant = builderAssistant;
    }

    public void parseStatementNode() {
        //解析XML中的sql语句
        String id = context.getStringAttribute("id");
        SqlSource sqlSource = createSqlSource(this.context);
        //获取 resultType resultMap
        String resultType = context.getStringAttribute("resultType");
        String nodeName = context.getName();
        builderAssistant.addMappedStatement(id, nodeName, resultType, sqlSource);
    }

    private SqlSource createSqlSource(XNode context) {
        String sql = context.getStringBody();
        SqlSource sqlSource = new StaticSqlSource(sql);
        return sqlSource;
    }
}
