package com.huangxw.fifty.thread;


import org.junit.Test;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.*;


public class CompletableFutureTest {
    
    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    
    /**
     * 轮询异步结果并获取
     */
    @Test
    public void testFutureAsk() throws ExecutionException, InterruptedException{
        //任务1
        Future<String> runnableFuture = executor.submit(new Runnable() {
            @Override
            public void run() {
               
                try {
                    System.out.println("Runnable异步线程开始....");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Runnable异步线程结束....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
            }
        },"fakeRunnableResult");
        
        //任务2
        Future<String> callableFuture = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Callable异步线程开始...");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Callable异步线程结束...");
                return "callableResult";
            }
        });
        
        boolean runnableDone = false;
        boolean callableDone = false;
        //不断轮询，直到有任务结束
        while (true)
        {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("轮询异步结果...");
            if(runnableFuture.isDone())
            {
                System.out.println("Runnable执行结果：" + runnableFuture.get());
                runnableDone = true;
            }
            if(callableFuture.isDone())
            {
                System.out.println("Runnable执行结果：" + callableFuture.get());
                callableDone = true;
            }
            if(runnableDone && callableDone) break;
        }
    
        System.out.println("任务全部结束");
        
    }
    
    public static void main(String[] args) {
    
        char key   = 'A' - 1;
        char end   = 'Z';
        Map<Character,Integer> map = new HashMap<>();
        while (key < end) {
            key++;
            map.put(key, 0);
        }
        
        Scanner s=new Scanner(System.in);
        System.out.println("请输出字符串");
        String result = s.nextLine();
        char x[] = result.toCharArray();
        for(int i = 0; i < x.length; i++)
        {
            if(Character.isLetter(x[i]))
            {
                Character keyName = Character.toString(x[i]).toUpperCase().charAt(0);
                map.put(keyName,map.get(keyName) + 1);
            }
        }
        
        //按字母出现次数，从大到小排序
        Map<Character,Integer> map2=new LinkedHashMap<Character,Integer>();
        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEachOrdered(e -> map2.put(e.getKey(),e.getValue()));
        
        for(Character each : map2.keySet())
        {
            float num = (float)map2.get(each) * 100 / result.length();
            DecimalFormat df = new DecimalFormat("0.00");
            String resultTmp = df.format(num) + "%";
            System.out.println("字母：" + each +"；出现数量：" + map2.get(each) + "；百分比：" + resultTmp);
        }
    }
    
}
