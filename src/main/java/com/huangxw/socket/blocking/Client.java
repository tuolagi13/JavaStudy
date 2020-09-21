package com.huangxw.socket.blocking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    public static final String HOST = "localhost";

    public static void main(String[] args) {
        int num = 0;
        while (true)
        {
            Socket socket = null;
            num++;
            if(num >=10) break;
            try
            {
                //创建一个流套接字并将其连接到指定主机上的指定端口号
                socket = new Socket(HOST,MultiThreadEchoServer.DEFAULT_PORT);
                //读取服务端数据
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //向服务器发送数据
                PrintStream out = new PrintStream(socket.getOutputStream());
                String str = "发送数据" + num;
                out.println(str);

                String ret = input.readLine();
                System.out.println("服务端返回的数据：" + ret);

                out.close();
                input.close();
            }
            catch (Exception e)
            {
                System.out.println("客户端异常：" + e.getMessage());
            }
            finally
            {
                if (socket == null)
                {
                    try
                    {
                        socket.close();
                    }
                    catch (IOException e)
                    {
                        socket = null;
                        System.out.println("客户端final异常：" + e.getMessage());
                    }
                }
            }
        }
    }
}
