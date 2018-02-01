package com.ly.zmn48644.executor.resultset;

import com.ly.zmn48644.executor.parameter.ParameterHandler;
import com.ly.zmn48644.mapping.BoundSql;
import com.ly.zmn48644.mapping.MappedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 默认的结果集处理器
 */
public class DefaultResultSetHandler implements ResultSetHandler {
    private final MappedStatement ms;
    private final BoundSql boundSql;
    private final ParameterHandler parameterHandler;

    public DefaultResultSetHandler(MappedStatement ms, BoundSql boundSql, ParameterHandler parameterHandler) {
        this.ms = ms;
        this.boundSql = boundSql;
        this.parameterHandler = parameterHandler;
    }

    @Override
    public <E> List<E> handleResultSets(Statement stmt) throws SQLException {
        ResultSet resultSet = stmt.getResultSet();

        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));
        }

        return null;
    }
}
