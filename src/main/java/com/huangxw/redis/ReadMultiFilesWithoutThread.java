package com.huangxw.redis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 不用多线程读取多个文件
 */
public class ReadMultiFilesWithoutThread {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String filePath = "D:\\1";
        String filePath2 = "D:\\2";
        String filePath3 = "D:\\3";
        String filePath4 = "D:\\4";

        readFile(filePath);
        readFile(filePath2);
        readFile(filePath3);
        readFile(filePath4);
        long endTime = System.currentTimeMillis();
        System.out.println("====================================");
        System.out.println("The Totally executed Time : " + (endTime - startTime));


    }

    public static void readFile(String path){
        long start = System.currentTimeMillis();
        int bufLen = 256;

        try
        {
            RandomAccessFile raf = new RandomAccessFile(path,"rw");
            raf.seek(0);
            long countLen = new File(path).length();
            long times = countLen/bufLen + 1;
            byte[] buff = new byte[bufLen];
            int hasRead = 0;
            String result = null;
            for (int i = 0; i < times; i++)
            {
                hasRead = raf.read(buff);
                if(hasRead < 0) break;
                result = new String(buff,"gb2312");
            }


        } catch (Exception e)
        {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(path + " total time: " + (end - start));
    }
}
