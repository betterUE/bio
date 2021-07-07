package com.shizq.demo_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  客户端发送消息，服务端接收消息
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
            if((msg = br.readLine()) != null){
                System.out.println("服务端接收到" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
