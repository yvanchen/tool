package com.chenyuwen.tool.pool;

/**
 * 对象工厂
 * @author chenyuwen
 * @date 2020/7/22
 */
public interface ObjectFactory<T> {

    /**
     * 创建对象
     * @return
     */
    T createNew();
}
