package com.www.opeartor.test;

/**
 * Created by Vincent on 2017/5/21.
 */
public class TestInstance {

    public static void main(String[] args){
        System.out.println("创建测试单例1对象");
        Emperor emperor1 = Emperor.getInstance();
        emperor1.getName();
        System.out.println("创建测试单例2对象");
        Emperor emperor2= Emperor.getInstance();
        emperor1.getName();
        System.out.println("创建测试单例3对象");
        Emperor emperor3 = Emperor.getInstance();
        emperor1.getName();
        System.out.println("创建测试单例4对象");
        Emperor emperor4 = Emperor.getInstance();
        emperor1.getName();
    }
}
