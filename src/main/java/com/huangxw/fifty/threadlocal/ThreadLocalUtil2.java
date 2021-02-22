package com.huangxw.fifty.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * threadlocal工具类  封装threadlocal
 */
public class ThreadLocalUtil2 {
    
    private ThreadLocalUtil2() {
        
    }
    
    
    private static final ThreadLocal<Map<String,Object>> THREAD_CONTEXT = new MapThreadLocal();
    
    /**
     * 取出线程变量
     */
    public static Object get(String key) {
        //getContextMap表示要先获取THREAD_CONTEXT的value，也就是Map<String,Object>.
        return getContextMap().get(key);
    }
    
    /**
     * 存入线程变量
     */
    public static void put(String key,Object value) {
        
        getContextMap().put(key,value);
    }
    
    
    public static void remove(String key) {
        getContextMap().remove(key);
    }
    
    public static void clear() {
        getContextMap().clear();
    }
    
    
    private static Map<String,Object> getContextMap() {
        return THREAD_CONTEXT.get();
    }
    
    /**
     * 内部类 继承自ThreadLocal
     * 之所以要自定义MapThreadLocal，是为了重写原生ThreadLocal的initialValue()
     * 把ThreadLocal第一版中判断null的操作隐藏掉，让代码优雅一些
     */
    private static class MapThreadLocal extends ThreadLocal<Map<String,Object>> {
    
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String,Object>(8) {
              private static final long serialVersionID = 3637958959138295593L;
              
              @Override
              public Object put(String key,Object value) {
                  return super.put(key,value);
              }
            };
        }
    }
}
