package com.ly.zmn48644.executor.statement;

import com.ly.zmn48644.mapping.BoundSql;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class PreparedStatementHandler extends BaseStatementHandler {
    public PreparedStatementHandler(BoundSql boundSql) {
        super(boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) {
        return null;
    }

    @Override
    public void parameterize(Statement statement) {

    }

    @Override
    public int update(Statement statement) {
        return 0;
    }

    @Override
    public <E> List<E> query(Statement statement) {
        return null;
    }
}
