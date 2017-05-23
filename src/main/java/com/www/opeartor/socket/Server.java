package com.www.opeartor.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Vincent on 2017/5/21.
 */
public class Server {

    private static Socket socket = null;

    private static ServerSocket serverSocket = null;

    public static void main(String[] args){
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            // 创建一个ServerSocket监听9090端口
            serverSocket = new ServerSocket(9090);
            while (true){
                System.out.println("start wait request......");
                // 等待请求
                // 监听并接受到此套接字的连接。此方法在连接传入之前一直阻塞。
                socket = serverSocket.accept();
                System.out.println("accept request: " + socket.toString() +"\ttime=" + new Date().getTime());
                // 接收到请求后使用socket进行通信, 创建BufferedReader用于读取数据
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = bufferedReader.readLine();
                System.out.println("received from client: "  + line + "\ttime=" + new Date().getTime());
                // 创建PrintWriter, 用于发送数据
                printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.println("received data: " + line + "\ttime=" + new Date().getTime());
                printWriter.flush();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭所有资源
            try {
                bufferedReader.close();
                printWriter.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
