package com.ly.zmn48644.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 默认的结果集处理器
 */
public class DefaultResultSetHandler implements  ResultSetHandler{

    @Override
    public <E> List<E> handleResultSets(Statement stmt) throws SQLException {

        return null;
    }
}
