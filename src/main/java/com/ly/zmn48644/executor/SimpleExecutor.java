package com.ly.zmn48644.executor;

import com.ly.zmn48644.executor.statement.StatementHandler;
import com.ly.zmn48644.mapping.MappedStatement;
import com.ly.zmn48644.session.Configuration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 普通执行器实现
 */
public class SimpleExecutor extends BaseExecutor {

    @Override
    public <E> List<E> doQuery(MappedStatement mappedStatement, Object parameter) throws SQLException {
        //调用全局配置对象获取 StatementHandler 对象
        Configuration configuration = mappedStatement.getConfiguration();
        StatementHandler statementHandler = configuration.newStatementHandler(mappedStatement, parameter);

        Statement statement = prepareStatement(statementHandler);

        return statementHandler.query(statement);
    }

    private Statement prepareStatement(StatementHandler statementHandler) throws SQLException {

        statementHandler.prepare(null,1);
        return null;
    }

    @Override
    public int doUpdate(MappedStatement mappedStatement, Object parameter) {
        return 0;
    }

}
