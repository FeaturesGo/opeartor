package com.www.opeartor.socket;

import java.net.InetAddress;

/**
 * InetAddress类用于标识网络上的硬件资源，标识互联网协议(IP)地址
 * Created by Vincent on 2017/6/13.
 */
public class InetAddressTest {

    public static void main(String[] args)throws Exception{

        //获取本机的InetAddress
        InetAddress address = InetAddress.getLocalHost();
        //获取计算机名
        String hosName = address.getHostName();
        //获取IP地址
        String hostAddress = address.getHostAddress();
        //获取字节数组形式的IP地址,以点分隔的四部分
        byte[] bytes = address.getAddress();


        System.out.println("计算机名: " + hosName + " " + "IP地址: " + hostAddress + " "+bytes);


    }
}
