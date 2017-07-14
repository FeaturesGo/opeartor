package com.www.opeartor.thread;

/**
 * Created by Vincent on 2017/7/7.
 */
public class TestThreadPool {

    public static void main(String[] args){
        ThreadPool t = ThreadPool.getThreadPool(3);
        t.execute(new Runnable[] { new Task(), new Task(), new Task() });
        t.execute(new Runnable[] { new Task(), new Task(), new Task() });
        System.out.println(t);
        t.destroy();// 所有线程都执行完成才destory
        System.out.println(t);
    }

    static class Task implements Runnable{

        private static volatile int i = 1;

        @Override
        public void run() {
           System.out.println("任务 " + (i++) + " 完成");
        }
    }
}
