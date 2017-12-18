package com.ly.zmn48644.executor;

import com.ly.zmn48644.mapping.MappedStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通执行器实现
 */
public class SimpleExecutor extends BaseExecutor {

    @Override
    public <E> List<E> doQuery(MappedStatement mappedStatement, Object parameter) {
        System.out.printf("SimpleExecutor:doQuery");
        return new ArrayList<>();
    }

    @Override
    public int doUpdate(MappedStatement mappedStatement, Object parameter) {
        return 0;
    }

}
