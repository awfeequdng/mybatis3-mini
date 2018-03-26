package com.ly.zmn48644.executor.parameter;

import com.ly.zmn48644.mapping.BoundSql;
import com.ly.zmn48644.mapping.MappedStatement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DefaultParameterHandler implements ParameterHandler {
    private final MappedStatement ms;
    private final Object parameter;
    private final BoundSql boundSql;

    public DefaultParameterHandler(MappedStatement ms, Object parameter, BoundSql boundSql) {
        this.ms = ms;
        this.parameter = parameter;
        this.boundSql = boundSql;

    }

    @Override
    public Object getParameterObject() {
        return parameter;
    }

    @Override
    public void setParameters(PreparedStatement ps) throws SQLException {

    }
}
