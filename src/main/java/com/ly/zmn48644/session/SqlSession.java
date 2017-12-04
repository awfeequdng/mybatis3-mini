
package com.ly.zmn48644.session;

/**
 * 提供给上层引用的,用于获取mapper对象.
 */
public interface SqlSession {
    <T> T getMapper(Class<T> type);
}
