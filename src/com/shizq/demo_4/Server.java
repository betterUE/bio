package com.shizq.demo_4;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：开发实现伪异步通信框架
 */
public class Server {
    public static void main(String[] args) {
        try{
            //1.注册端口
            ServerSocket ss = new ServerSocket(9999);
            //初始化线程池对象
            HandlerSocketServerPool pool = new HandlerSocketServerPool(3,10);
            //2.定义循环接收客户端的链接请求
            while(true){
                Socket st = ss.accept();
                //3. 把socket对象交给一个线程池进行维护
               Runnable target = new ServerRunnableTarget(st);
               pool.execute(target);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
