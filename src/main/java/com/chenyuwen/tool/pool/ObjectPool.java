package com.chenyuwen.tool.pool;

/**
 * 对象池
 * @author chenyuwen
 * @date 2020/7/22
 */
public interface ObjectPool<T> {

    /**
     * 获取对象
     * @return
     */
    T get();

    /**
     * 对象放回对象池
     * @param t
     */
    void returnPool(T t);
}
