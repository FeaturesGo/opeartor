package com.www.opeartor.test;

/**
 *
 * 用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值
 * Created by Vincent on 2017/7/9.
 */
public class Counter {

    public static volatile int count = 0;

    public static void inc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args){
        for (int i = 0; i < 1000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc();
                }
            }).start();
        }
        System.out.println("运行结果:Counter.count=" + Counter.count);
    }
}
