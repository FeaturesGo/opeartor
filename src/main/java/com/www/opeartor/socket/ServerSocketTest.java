package com.www.opeartor.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Vincent on 2017/6/17.
 */
public class ServerSocketTest {

    private final static int port = 10086;

    /**
     * 基于TCP协议的Socket通信，实现用户登录，服务端
     */
    public static void serverSocketFunction(){

        //1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        ServerSocket serverSocket = null;//1024-65535的某个端口
        try {
            serverSocket = new ServerSocket(port);
            Socket socket = null;
            int count = 0;
            System.out.println("***服务器即将启动，等待客户端的连接***");
            //循环监听等待客户端的连接
            while (true){
                //2、调用accept()方法开始监听，等待客户端的连接
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端的数量："+count);
                InetAddress address=socket.getInetAddress();
                System.out.println("当前客户端的IP："+address.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)throws Exception{
        serverSocketFunction();
    }
}
