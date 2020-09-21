package com.huangxw.socket.blocking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *阻塞IO + 多线程模式
 * 存在问题：每次接收新连接都需要新建线程，处理完成后销毁线程，代价大。当有大量短链接出现时，性能较低
 * 可改进为阻塞IO + 线程池模式
 */
public class MultiThreadEchoServer {

    public static int DEFAULT_PORT = 7;

    public static void main(String[] args) {
        int port;
        try
        {
            port = Integer.parseInt(args[0]);
        }
        catch (RuntimeException ex)
        {
            port = DEFAULT_PORT;
        }

        Socket clientSocket = null;
        try (ServerSocket serverSocket = new ServerSocket(port);)
        {
            while(true)
            {
                clientSocket = serverSocket.accept();

                //多线程
                new Thread(new EchoServerHandler(clientSocket)).start();
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception caught when trying to listen on port " + port);
            System.out.println(e.getMessage());
        }
    }
}
