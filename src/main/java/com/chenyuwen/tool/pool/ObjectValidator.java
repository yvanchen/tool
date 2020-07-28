package com.chenyuwen.tool.pool;

/**
 * 对象校验器
 * @author chenyuwen
 * @date 2020/7/22
 */
public interface ObjectValidator<T> {

    /**
     * 判断对象有效性
     * @param t
     * @return
     */
    boolean valid(T t);
}
