package com.shizq.demo_4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 任务对象
 */
public class ServerRunnableTarget implements Runnable{
   private Socket socket;
   public ServerRunnableTarget(Socket socket){
       this.socket = socket;
   }

    @Override
    public void run() {
        //处理接收到的客户端Socket通信需求
        try{
            InputStream is = socket.getInputStream();
            //把字节输入流包装成一个缓冲字符输入流
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String msg;
            while((msg = br.readLine()) != null){
                System.out.println("服务端接收到：" + msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
