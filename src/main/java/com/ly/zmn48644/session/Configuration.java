package com.ly.zmn48644.session;

import com.ly.zmn48644.binding.MapperRegistry;
import com.ly.zmn48644.executor.Executor;
import com.ly.zmn48644.executor.SimpleExecutor;
import com.ly.zmn48644.executor.statement.RoutingStatementHandler;
import com.ly.zmn48644.executor.statement.SimpleStatementHandler;
import com.ly.zmn48644.executor.statement.StatementHandler;
import com.ly.zmn48644.mapping.BoundSql;
import com.ly.zmn48644.mapping.Environment;
import com.ly.zmn48644.mapping.MappedStatement;
import com.ly.zmn48644.transaction.Transaction;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局配置中心
 */
public class Configuration {


    /**
     * 数据源环境
     */
    protected Environment environment;

    private MapperRegistry mapperRegistry = new MapperRegistry();
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    /**
     * 向mappedStatements中添加解析到的 MappedStatement
     *
     * @param ms
     */
    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    /**
     * 根据Id获取MappedStatement
     *
     * @param id
     * @return
     */
    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    /**
     * 创建 statement 处理器
     *
     * @return
     */
    public StatementHandler newStatementHandler(MappedStatement mappedStatement, Object parameter) {
        StatementHandler statementHandler = new RoutingStatementHandler(mappedStatement, parameter);
        return statementHandler;
    }

    /**
     * 创建执行器
     *
     * @param execType
     * @return
     */
    public Executor newExecutor(Transaction transaction, ExecutorType execType) {
        Executor executor;
        if (ExecutorType.BATCH.equals(execType)) {
            executor = null;
        } else if (ExecutorType.REUSE.equals(execType)) {
            executor = null;
        } else {
            executor = new SimpleExecutor(transaction);
        }
        return executor;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
