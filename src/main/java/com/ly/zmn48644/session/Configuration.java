package com.ly.zmn48644.session;

import com.ly.zmn48644.binding.MapperRegistry;
import com.ly.zmn48644.datasource.unpooled.UnpooledDataSourceFactory;
import com.ly.zmn48644.executor.Executor;
import com.ly.zmn48644.executor.SimpleExecutor;
import com.ly.zmn48644.executor.parameter.DefaultParameterHandler;
import com.ly.zmn48644.executor.parameter.ParameterHandler;
import com.ly.zmn48644.executor.resultset.DefaultResultSetHandler;
import com.ly.zmn48644.executor.resultset.ResultSetHandler;
import com.ly.zmn48644.executor.statement.RoutingStatementHandler;
import com.ly.zmn48644.executor.statement.SimpleStatementHandler;
import com.ly.zmn48644.executor.statement.StatementHandler;
import com.ly.zmn48644.mapping.BoundSql;
import com.ly.zmn48644.mapping.Environment;
import com.ly.zmn48644.mapping.MappedStatement;
import com.ly.zmn48644.transaction.Transaction;
import com.ly.zmn48644.transaction.jdbc.JdbcTransactionFactory;
import com.ly.zmn48644.type.TypeAliasRegistry;

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

    private TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    private MapperRegistry mapperRegistry = new MapperRegistry();

    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();


    public Configuration() {
        //注册事务管理器别名
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        //注册非池化数据源别名
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);

    }

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

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    /**
     * 创建参数处理器
     * @param ms
     * @param parameter
     * @param boundSql
     * @return
     */
    public ParameterHandler newParameterHandler(MappedStatement ms, Object parameter, BoundSql boundSql) {
        ParameterHandler parameterHandler = new DefaultParameterHandler(ms,parameter,boundSql);
        return parameterHandler;
    }

    /**
     * 创建结果集处理器
     * @param ms
     * @param boundSql
     * @param parameterHandler
     * @return
     */
    public ResultSetHandler newResultSetHandler(MappedStatement ms, BoundSql boundSql, ParameterHandler parameterHandler) {
        ResultSetHandler resultSetHandler = new DefaultResultSetHandler(ms,boundSql,parameterHandler);
        return resultSetHandler;
    }
}

















