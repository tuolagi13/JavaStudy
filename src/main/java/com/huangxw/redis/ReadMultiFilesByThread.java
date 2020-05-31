package com.huangxw.redis;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 多线程同时读取多个文件
 */
public class ReadMultiFilesByThread {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int thNum = 4;
        String filePath = "D:\\1";
        String filePath2 = "D:\\2";
        String filePath3 = "D:\\3";
        String filePath4 = "D:\\4";

        CountDownLatch doneSignal = new CountDownLatch(thNum);
        ReadFileThread r1 = new ReadFileThread(doneSignal,filePath);
        ReadFileThread r2 = new ReadFileThread(doneSignal,filePath2);
        ReadFileThread r3 = new ReadFileThread(doneSignal,filePath3);
        ReadFileThread r4 = new ReadFileThread(doneSignal,filePath4);
        r1.start();
        r2.start();
        r3.start();
        r4.start();
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("===============================");
        System.out.println("The Totally executed Time : " + (endTime - startTime));
        //ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1);
        Executors.newFixedThreadPool(1);


    }
}

class ReadFileThread extends Thread {
    private RandomAccessFile raf;
    private CountDownLatch doneSignal;
    private int bufLen = 256;
    private String path;

    public ReadFileThread(CountDownLatch doneSignal,String path){
        this.doneSignal = doneSignal;
        this.path = path;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try
        {
            raf = new RandomAccessFile(path,"rw");
            raf.seek(0);
            long countLen = new File(path).length();
            long times = countLen/bufLen + 1;
            byte[] buff = new byte[bufLen];
            int hasRead = 0;
            String result = null;
            for (int i = 0; i < times; i++)
            {
                hasRead = raf.read(buff);
                if(hasRead < 0)  break;
                result = new String (buff,"gb2312");
            }
            doneSignal.countDown();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(getName() + " FilePath: " + path + "Total Time :" + (end - start));
    }
}
