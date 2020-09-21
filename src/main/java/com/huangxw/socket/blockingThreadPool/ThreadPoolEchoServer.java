package com.huangxw.socket.blockingThreadPool;

import com.huangxw.socket.blocking.EchoServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阻塞IO + 线程池模式
 * 存在问题：
 * 大量短连接的场景中性能会提升，因为不用每次都创建和销毁线程，而是重用线程池中的线程。
 * 但在大量长连接的场景中，因为线程被连接长期占用，不需要频繁的创建和销毁线程，因而没什么优势
 * 虽然这种方法可以使用于小到中规模的客户端并发数，如果连接数超过10000或更多，性能会很不理想
 *可改进为 非阻塞IO 模式(java NIO)
 */
public class ThreadPoolEchoServer {
    public static int DEFAULT_PORT = 7;

    public static void main(String[] args) throws IOException {
        int port;

        try
        {
            port = Integer.parseInt(args[0]);
        }
        catch (RuntimeException ex)
        {
            port = DEFAULT_PORT;
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Socket clientSocket = null;

        try (ServerSocket serverSocket = new ServerSocket(port);)
        {
            while (true)
            {
                clientSocket = serverSocket.accept();

                //线程池
                threadPool.submit(new Thread(new EchoServerHandler(clientSocket)));
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception caught when trying to listen on port " + port);
            System.out.println(e.getMessage());
        }
    }
}
