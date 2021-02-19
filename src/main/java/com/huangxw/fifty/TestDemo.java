package com.huangxw.fifty;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestDemo {
    
    
    @Test
    public void testForEachLinkedList() {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 10000; i++) 
            list.add(String.valueOf(i));
        
        long start = System.currentTimeMillis();
        //测试普通for的查询效率
//        for (int i = 0; i < list.size(); i++) 
//            System.out.println(list.get(i));
//    
//        System.out.println("普通for耗时：" + (System.currentTimeMillis() - start));
        
        //推荐增强for循环 内部有优化
        for(String s : list)
            System.out.println(s);
    
        System.out.println("增强for耗时：" + (System.currentTimeMillis() - start));
    }
    
    @Test
    public void testForEachArrayList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++)
            list.add(String.valueOf(i));
        
        long start = System.currentTimeMillis();
        //测试普通for的查询效率
        for (int i = 0; i < list.size(); i++) 
            System.out.println(list.get(i));

        System.out.println("普通for耗时：" + (System.currentTimeMillis() - start));
        
        //推荐增强for循环 内部有优化
//        for(String s : list)
//            System.out.println(s);
//        
//        System.out.println("增强for耗时：" + (System.currentTimeMillis() - start));
    }
}
