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


        MappedStatement ms = new MappedStatement();
        //命名空间 + 方法名
        ms.setId(builderAssistant.getCurrentNamespace() + "." + id);
        ms.setSqlSource(sqlSource);
        String nodeName = context.getName();
        SqlCommandType sqlCommandType = SqlCommandType.valueOf(nodeName.toUpperCase(Locale.ENGLISH));
        ms.setSqlCommandType(sqlCommandType, configuration);

        this.configuration.addMappedStatement(ms);

    }

    private SqlSource createSqlSource(XNode context) {
        String sql = context.getStringBody();
        SqlSource sqlSource = new StaticSqlSource(sql);
        return sqlSource;
    }
}
