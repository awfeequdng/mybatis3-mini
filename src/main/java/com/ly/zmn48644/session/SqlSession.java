
package com.ly.zmn48644.session;

import java.util.List;

/**
 * 提供给上层引用的,用于获取mapper对象.
 */
public interface SqlSession {


    <E> List<E> selectList(String statement);

    <T> T getMapper(Class<T> type);

    Configuration getConfiguration();
}
