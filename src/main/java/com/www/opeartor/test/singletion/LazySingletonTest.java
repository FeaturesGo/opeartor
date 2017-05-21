package com.www.opeartor.test.singletion;

/**
 *懒汉式单例类测试
 * Created by Vincent on 2017/5/21.
 */
public class LazySingletonTest {

    public static void main(String[] args){
        System.out.println("创建懒汉式单例类1对象");
        LazySingleton lazyInstance1 = LazySingleton.getLazyInstance();
        lazyInstance1.getName();
        System.out.println("创建懒汉式单例类2对象");
        LazySingleton lazyInstance2 = LazySingleton.getLazyInstance();
        lazyInstance2.getName();
        System.out.println("创建懒汉式单例类3对象");
        LazySingleton lazyInstance3 = LazySingleton.getLazyInstance();
        lazyInstance3.getName();
    }
}
