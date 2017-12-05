package com.ly.zmn48644.build.xml;

import com.ly.zmn48644.binding.MapperMethod;
import com.ly.zmn48644.build.BaseBuilder;
import com.ly.zmn48644.build.StaticSqlSource;
import com.ly.zmn48644.mapping.MappedStatement;
import com.ly.zmn48644.mapping.SqlSource;
import com.ly.zmn48644.parsing.XNode;
import com.ly.zmn48644.session.Configuration;

public class XMLStatementBuilder extends BaseBuilder {
    private XNode context;

    public XMLStatementBuilder(Configuration configuration, XNode context) {
        super(configuration);
        this.context = context;
    }

    public void parseStatementNode() {
        //解析XML中的sql语句
        String id = context.getStringAttribute("id");
        SqlSource sqlSource = createSqlSource(this.context);


        MappedStatement ms = new MappedStatement();
        ms.setId(id);
        ms.setSqlSource(sqlSource);
        this.configuration.addMappedStatement(ms);

    }

    private SqlSource createSqlSource(XNode context) {
        String sql = context.getStringBody();
        SqlSource sqlSource = new StaticSqlSource(sql);
        return sqlSource;
    }
}
