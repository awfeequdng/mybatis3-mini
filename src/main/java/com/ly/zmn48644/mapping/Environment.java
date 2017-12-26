package com.ly.zmn48644.mapping;

import com.ly.zmn48644.transaction.TransactionFactory;

/**
 * 框架运行环境对象
 * 主要封装的是数据源和事务管理器工厂
 *
 */
public class Environment {
    private String id;
    private TransactionFactory transactionFactory;

    public Environment(String id, TransactionFactory transactionFactory) {
        this.id = id;
        this.transactionFactory = transactionFactory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionFactory getTransactionFactory() {
        return transactionFactory;
    }

    public void setTransactionFactory(TransactionFactory transactionFactory) {
        this.transactionFactory = transactionFactory;
    }
}
