package com.chenyuwen.tool;

import com.chenyuwen.tool.pool.ObjectFactory;
import com.chenyuwen.tool.pool.ObjectPool;
import com.chenyuwen.tool.pool.SimpleObjectPool;

/**
 * @author chenyuwen
 * @date 2020/7/22
 */
public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        for(int i=0;i<10;i++){
//            Demo demo=new Demo();
//            demo.setNum(i);
//            System.out.println(demo);
//        }
        ObjectPool<Demo> objectPool = new SimpleObjectPool<>(demo -> true, new ObjectFactory<Demo>() {
            private int i;

            @Override
            public Demo createNew() {
                Demo demo = new Demo();
                demo.setNum(i++);
                return demo;
            }
        }, 4);
        for(int i=0;i<100;i++){
            Demo demo=objectPool.get();
            System.out.println(demo);
            objectPool.returnPool(demo);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start));
    }
}
