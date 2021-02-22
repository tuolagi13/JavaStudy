package com.huangxw.fifty.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalMap extends ThreadLocal<Map<String,Object>> {
    
    private ThreadLocalMap() {}
    
    private final static ThreadLocal<Map<String,Object>> THREAD_CONTEXT = new ThreadLocalMap();
    
    public static Object get(String key) {
        return THREAD_CONTEXT.get().get(key);
    }
    
    public static void put(String key,String value) {
        THREAD_CONTEXT.get().put(key,value);
    }
    
    public static void remove(String key) {
        THREAD_CONTEXT.get().remove(key);
    }
    
    public static void clear() {
        THREAD_CONTEXT.get().clear();
    }
    
    public static void clearAll() {
        THREAD_CONTEXT.remove();
    }
    
    @Override
    protected Map<String,Object> initialValue() {
        return new HashMap<String,Object>(8) {
            private static final long serialVersionUID = 3637958959138295593L;
            
            public Object put(String key,String value) {
                return super.put(key,value);
            }
        };
    }
    
    //测试
    public static void main(String[] args) {
        ThreadLocalMap.put("mainKey","mainValue");
        new Thread(() -> {
            ThreadLocalMap.put("threadKey","threadValue");
            System.out.println("get main value in thread:" + ThreadLocalMap.get("mainKey"));
            System.out.println("get thread value in thread:" + ThreadLocalMap.get("threadKey"));
        }).start();
    
        System.out.println("get thread value in main:" + ThreadLocalMap.get("threadKey"));
        System.out.println("get main value in main:" + ThreadLocalMap.get("mainKey"));
    }
    
    
}
