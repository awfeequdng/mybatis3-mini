package com.ly.zmn48644.executor.statement;

import com.ly.zmn48644.mapping.BoundSql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SimpleStatementHandler extends BaseStatementHandler {


    public SimpleStatementHandler(BoundSql boundSql) {
        super(boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    @Override
    public void parameterize(Statement statement) {

    }

    @Override
    public int update(Statement statement) throws SQLException {
        String sql = boundSql.getSql();
        int rows;
        statement.executeUpdate(sql);
        rows = statement.getUpdateCount();
        return rows;
    }

    @Override
    public <E> List<E> query(Statement statement) throws SQLException {
        String sql = boundSql.getSql();
        ResultSet resultSet = statement.executeQuery(sql);
        //处理查询到的结果
        return null;
    }
}
