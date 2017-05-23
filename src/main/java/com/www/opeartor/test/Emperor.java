package com.www.opeartor.test;

import java.util.concurrent.CountDownLatch;

/**
 * 单例模式
 * 1.私有的静态的实例对象 private static instance
 * 2.私有的构造函数（保证在该类外部，无法通过new的方式来创建对象实例） private Singleton(){}
 * 3.公有的、静态的、访问该实例对象的方法 public static Singleton getInstance(){}
 * Created by Vincent on 2017/5/21.
 */
public class Emperor {

    //声明一个Emperor类的引用
    private static Emperor emperor = null;
    //将构造方法私有
    private Emperor(){}
    //实例化引用
    public static Emperor getInstance(){
        if (emperor == null){
            emperor = new Emperor();
        }
        return emperor;
    }

    public void getName(){
        System.out.println("测试单例");
    }

    /**
     * 测试单例方法
     * @param args
     */
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        int threadCount = 1000;

        for (int i = 0; i < threadCount; i++) {
            new Thread() {

                @Override
                public void run() {
                    try {
                        // all thread to wait
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // test get instance
                    System.out.println(Emperor.getInstance().hashCode());
                }
            }.start();
        }

        // release lock, let all thread excute Singleton.getInstance() at the same time
        latch.countDown();
    }
}
