package com.ly.zmn48644.executor.statement;

import com.ly.zmn48644.executor.resultset.ResultSetHandler;
import com.ly.zmn48644.mapping.BoundSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseStatementHandler implements StatementHandler {

    private final BoundSql boundSql;

    //private final ResultSetHandler resultSetHandler;

    public BaseStatementHandler(BoundSql boundSql) {
        this.boundSql = boundSql;
    }

    @Override
    public Statement prepare(Connection connection, Integer transactionTimeout) throws SQLException {
        Statement statement = instantiateStatement(connection);
        //TODO 设置超时时间

        //TODO 设置fetchSize
        return statement;
    }

    protected abstract Statement instantiateStatement(Connection connection) throws SQLException;

}
