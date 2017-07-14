package com.www.opeartor.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * URL(Uniform Resource Locator)统一资源定位符，表示Internet上某一资源的地址，协议名：资源名称
 * Created by Vincent on 2017/6/13.
 */
public class URLTest {


    public static void getResourceLocator() throws Exception{

        URL baidu = new URL("https://www.baidu.com");
        URL url =new URL(baidu,"/index.html?username=tom#test");//？表示参数，#表示锚点
        String  protocol = url.getProtocol();//获取协议
        String  host = url.getHost();//获取主机
        int port = url.getPort();//如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
        String path = url.getPath();//获取文件路径
        String file = url.getFile();//文件名，包括文件路径+参数
        String ref = url.getRef();//相对路径，就是锚点，即#号后面的内容
        String query = url.getQuery();//查询字符串，即参数

        System.out.println("获取协议: " + protocol);
        System.out.println("获取主机: " + host);
        System.out.println("端口: " + port);
        System.out.println("获取文件路径: " + path);
        System.out.println("文件名: " + file);
        System.out.println("相对路径: " + ref);
        System.out.println("查询字符串: " + query);

    }

    public static void getReadPage()throws Exception{
        URL url =new URL("http://www.baidu.com");
        InputStream is = url.openStream();//通过openStream方法获取资源的字节输入流
        InputStreamReader isr =new InputStreamReader(is,"UTF-8");//将字节输入流转换为字符输入流,如果不指定编码，中文可能会出现乱码
        BufferedReader br =new BufferedReader(isr);//为字符输入流添加缓冲，提高读取效率
        String data = br.readLine();//读取数据
        while(data!=null){
            System.out.println(data);//输出数据
            data = br.readLine();
        }
        br.close();
        isr.close();
        is.close();
    }

    public static void main(String[] args)throws Exception{
        getResourceLocator();
        getReadPage();
    }

}
