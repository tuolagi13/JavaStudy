package com.huangxw.fifty.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * threadlocal工具类  封装threadlocal
 */
public class ThreadLocalUtil {
    
    private ThreadLocalUtil() {
        
    }
    
    
    private static final ThreadLocal<Map<String,Object>> THREAD_CONTEXT = new ThreadLocal<Map<String, Object>>();
    
    /**
     * 存入线程变量
     */
    public static void put(String key,Object value) {
        
        Map<String,Object> map = THREAD_CONTEXT.get();
        //第一次从ThreadLocalMap中根据threadlocal取出的value可能是null

        if (map == null)
        {
            map = new HashMap<>();
            THREAD_CONTEXT.set(map);
        }
        map.put(key,value);
    }
    
    /**
     * 取出线程变量
     */
    public static Object get(String key) {
        Map<String,Object> map = THREAD_CONTEXT.get();
        return map == null ? null : map.get(key);
    }
    
    
    public static void remove(String key) {
        Map<String,Object> map = THREAD_CONTEXT.get();
        map.remove(key);
    }
    
    public static void clear() {
        THREAD_CONTEXT.remove();
    }
}
