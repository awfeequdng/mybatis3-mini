package com.ly.zmn48644.mapping;

import com.ly.zmn48644.session.Configuration;

public class MappedStatement {
    private Configuration configuration;
    private String id;
    private SqlSource sqlSource;
    private SqlCommandType sqlCommandType;
    private StatementType statementType;

    public MappedStatement() {
        //默认是 PREPARED
        this.statementType = StatementType.PREPARED;
    }

    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    public void setSqlCommandType(SqlCommandType sqlCommandType, Configuration configuration) {
        this.sqlCommandType = sqlCommandType;
        this.configuration = configuration;
    }

    public StatementType getStatementType() {
        return statementType;
    }

    public void setStatementType(StatementType statementType) {
        this.statementType = statementType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SqlSource getSqlSource() {
        return sqlSource;
    }

    public void setSqlSource(SqlSource sqlSource) {
        this.sqlSource = sqlSource;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
