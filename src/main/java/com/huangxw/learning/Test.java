package com.huangxw.learning;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println("请输入内容：");
        System.out.println("A B C D格式为内容输入文件");
        System.out.println("查询 为查询文件内容");
        System.out.println("退出 为查询文件内容");
        Scanner input = new Scanner(System.in);
        while(input.hasNext())
        {
            if(input.next().equals("查询"))
            {

            }
            else if(input.next().equals("退出"))
            {
                System.out.println("正在退出程序...");
                input.close();
            }
            else
            {
                String A = input.next();
                String B = input.next();
                String C = input.next();
                String D = input.next();

            }
        }


    }

}
