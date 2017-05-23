package com.www.opeartor.test.singletion;

/**
 *
 * 线程安全的懒汉式单例的实现
 * Created by Vincent on 2017/5/21.
 */
public class SafeLazySingleton {

    private static SafeLazySingleton instance = null;

    private SafeLazySingleton(){}

    //1.对整个访问实例的方法进行同步
    public synchronized static SafeLazySingleton getInstance(){
        if (instance == null){
            instance = new SafeLazySingleton();
        }
        return instance;
    }

    //2.对必要的代码块进行同步
    public static SafeLazySingleton getInstance1(){
        if (instance == null){
            synchronized (SafeLazySingleton.class){
                if (instance == null){
                    instance = new SafeLazySingleton();
                }
            }
        }
        return instance;
    }
}
