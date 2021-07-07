package com.shizq.demo_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  服务端可以反复的接收消息，客户端也可以反复的发送消息
 */
public class Server {
    public static void main(String[] args) {

        try {
            System.out.println("=====服务端启动=====");
            //1.定义一个ServerSocket对象进行服务端的端口就注册
            ServerSocket ss = new ServerSocket(9999);
            //2.监听客端的Socket链接请求
            Socket socket = ss.accept();
            //3.从socket管道中得到一个字节输入流对象
            InputStream is = socket.getInputStream();
            //4.把字节输入流包装成一个缓冲字节输入流
            //但是缓冲字节输入流并不能按 行line 进行读取，只能读取字节
            //BufferedInputStream bis = new BufferedInputStream(is);
            //4.把字节输入流包装成一个缓冲字符输入流
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String msg;
            while((msg = br.readLine()) != null){
                System.out.println("服务端接收到：" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
