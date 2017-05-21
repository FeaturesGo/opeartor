package com.www.opeartor.test.singletion;

/**
 * 饥汉式单例实现测试
 * Created by Vincent on 2017/5/21.
 */
public class NoLazySingletonTest {

    public static void main(String[] args) {
        NoLazySingleton instance0 = NoLazySingleton.getInstance();
        NoLazySingleton instance1 = NoLazySingleton.getInstance();
        NoLazySingleton instance2 = NoLazySingleton.getInstance();
        NoLazySingleton instance3 = NoLazySingleton.getInstance();
    }
}
