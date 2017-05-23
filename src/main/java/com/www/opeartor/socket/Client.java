package com.www.opeartor.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Vincent on 2017/5/21.
 */
public class Client {

    public static void main(String[] args) {
        String msg = "Client Data";
        try {
            Socket socket = new Socket("127.0.0.1", 9090);

            // 先写、再读
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            // 发送数据
            printWriter.println(msg);
            printWriter.flush();
            // 获得服务端返回的数据
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = bufferedReader.readLine();
            System.out.println("received from server: " + line + "\ttime=" + new Date().getTime());
            // 关闭资源
            printWriter.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
