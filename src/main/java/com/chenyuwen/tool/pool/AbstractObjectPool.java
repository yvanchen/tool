package com.chenyuwen.tool.pool;

import java.util.Queue;

/**
 * @author chenyuwen
 * @date 2020/7/22
 */
public abstract class AbstractObjectPool<T> implements ObjectPool<T> {

    private ObjectValidator<T> objectValidator;

    private ObjectFactory<T> objectFactory;

    private Queue<T> queue;

    private Integer length;

    public AbstractObjectPool(ObjectValidator<T> objectValidator, ObjectFactory<T> objectFactory, Queue<T> queue, Integer length) {
        this.objectValidator = objectValidator;
        this.objectFactory = objectFactory;
        this.queue = queue;
        this.length = length;
        init();
    }

    public abstract void validFailHandler(T t);

    private void init(){
        for(int i=0;i<length;i++){
            queue.offer(objectFactory.createNew());
        }
    }

    @Override
    public T get() {
        return queue.poll();
    }

    @Override
    public void returnPool(T t) {
        if(objectValidator.valid(t)){
            queue.offer(t);
        }else{
            validFailHandler(t);
        }
    }
}
