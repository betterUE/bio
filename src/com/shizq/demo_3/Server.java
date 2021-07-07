package com.shizq.demo_3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现服务端可以同时接收多个客户端的socket通信请求
 * 思路：是服务端每接收一个客户端socket请求对象之后，都交给一个独立的线程来处理客户端的数据交互需求
 */
public class Server {
    public static void main(String[] args) {

        try {
            //1.注册端口
            ServerSocket ss = new ServerSocket(9999);
            //2.定义一个死循环，负责不断的接收客户端的socket链接请求
            while (true){
                Socket socket = ss.accept();
                //3.创建一个独立的线程，来处理与这个客户端的socket通信需求
                new ServerThreadReader(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
