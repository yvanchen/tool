package com.chenyuwen.tool.pool;

import java.util.LinkedList;

/**
 * @author chenyuwen
 * @date 2020/7/22
 */
public class SimpleObjectPool<T> extends AbstractObjectPool<T> {
    public SimpleObjectPool(ObjectValidator<T> objectValidator, ObjectFactory<T> objectFactory,  Integer length) {
        super(objectValidator, objectFactory, new LinkedList<>(), length);
    }

    @Override
    public void validFailHandler(T t) {

    }
}
