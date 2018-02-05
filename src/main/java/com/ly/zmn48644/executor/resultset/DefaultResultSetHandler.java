package com.ly.zmn48644.executor.resultset;

import com.ly.zmn48644.executor.parameter.ParameterHandler;
import com.ly.zmn48644.mapping.BoundSql;
import com.ly.zmn48644.mapping.MappedStatement;
import com.ly.zmn48644.mapping.ResultMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

        final List<Object> multipleResults = new ArrayList<>();

        ResultSet resultSet = stmt.getResultSet();

        ResultMap resultMap = ms.getResultMap();


         handleResultSet(resultSet,resultMap,multipleResults);

        return null;
    }

    private void handleResultSet(ResultSet resultSet, ResultMap resultMap, List<Object> multipleResults) {

    }
}
