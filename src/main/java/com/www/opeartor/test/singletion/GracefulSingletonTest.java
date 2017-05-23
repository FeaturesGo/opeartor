package com.www.opeartor.test.singletion;

/**
 * Created by Vincent on 2017/5/21.
 */
public class GracefulSingletonTest {

    public static void main(String[] args){
        GracefulSingleton gracefulSingleton1 = GracefulSingleton.getInstance();
        GracefulSingleton gracefulSingleton2 = GracefulSingleton.getInstance();
        GracefulSingleton gracefulSingleton3 = GracefulSingleton.getInstance();
    }
}
