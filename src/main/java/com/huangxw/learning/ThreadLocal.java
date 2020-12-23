//package com.huangxw.learning;
//
//
//import java.lang.ref.WeakReference;
//import java.util.Objects;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.function.Supplier;
//
///**
// *threadlocal学习
// */
//public class ThreadLocal<T> {
//
//    private final int threadLocalHashCode =nextHashCode();
//    private static AtomicInteger nextHashCode = new AtomicInteger();
//    private static final int HASH_INCREMENT = 1640531527;
//
//    private static int nextHashCode() {
//        return nextHashCode.getAndAdd(HASH_INCREMENT);
//    }
//
//    protected T initialValue() {return null;}
//
//    public static <S> ThreadLocal<S> withInitial(Supplier<? extends S> supplier) {
//        return new SuppliedThreadLocal<>(supplier);
//    }
//
//    public ThreadLocal() {}
//
//
//
//    public T get() {
//        Thread t = Thread.currentThread();
//        ThreadLocalMap map = getMap(t);
//        if (map != null)
//        {
//            ThreadLocalMap.Entry e = map.getEntry(this);
//            if (e != null)
//            {
//                @SuppressWarnings("unchecked")
//                T result = (T)e.value;
//                return result;
//            }
//        }
//        return setInitialValue();
//    }
//
//    private T setInitialValue() {
//        T value = initialValue();
//        Thread t = Thread.currentThread();
//        ThreadLocalMap map = getMap(t);
//        if (map != null)
//            map.set(this, value);
//        else
//            createMap(t, value);
//        return value;
//    }
//
//    void createMap(Thread t, T firstValue) { t.threadLocals = new ThreadLocalMap(this, firstValue); }
//
//    static ThreadLocalMap createInheritedMap(ThreadLocalMap parentMap) { return new ThreadLocalMap(parentMap);}
//
//    T childValue(T parentValue) {
//        throw new UnsupportedOperationException();
//    }
//
//    ThreadLocalMap getMap(Thread t) {
//        return t.threadLocals;
//    }
//
//    static final class SuppliedThreadLocal<T> extends ThreadLocal<T> {
//        //函数接口
//        private final Supplier<? extends T> supplier;
//        //构造函数中为该接口赋值
//        SuppliedThreadLocal(Supplier<? extends T> supplier) {
//            this.supplier = Objects.requireNonNull(supplier);
//        }
//
//        @Override
//        protected T initialValue() {
//            return this.supplier.get();
//        }
//    }
//
//    static class ThreadLocalMap {
//
//        static class Entry extends WeakReference<ThreadLocal<?>> {
//
//            Object value;
//            Entry(ThreadLocal<?> k,Object v) {
//                super(k);
//                value = v;
//            }
//        }
//
//        private static final int INITIAL_CAPACITY = 16;
//
//        private Entry[] table;
//
//        private int size = 0;
//
//        private int threshold; //default to 0
//
//        private void setThreshold(int len) { threshold = len * 2 / 3; }
//
//        private static int nextIndex(int i, int len) { return ((i + 1 < len) ? i + 1 : 0); }
//
//        private static int prevIndex(int i, int len) { return ((i - 1 >= 0) ? i - 1 : len - 1 ); }
//
//        ThreadLocalMap(ThreadLocal<?> firstKey, Object firstValue) {
//            table = new Entry[INITIAL_CAPACITY];
//            int i =firstKey.threadLocalHashCode & (INITIAL_CAPACITY - 1);
//            table[i] = new Entry(firstKey, firstValue);
//            size = 1;
//            setThreshold(INITIAL_CAPACITY);
//        }
//
//        private ThreadLocalMap(ThreadLocalMap parentMap) {
//            Entry[] parentTable = parentMap.table;
//            int len = parentTable.length;
//            setThreshold(len);
//            table = new Entry[len];
//
//            for (int j = 0; j < len; j++)
//            {
//                Entry e = parentTable[j];
//                if (e != null)
//                {
//                    @SuppressWarnings("unchecked")
//                    ThreadLocal<Object> key = (ThreadLocal<Object>) e.get();
//                    if (key != null)
//                    {
//                        Object value = key.ChildValue(e.value);
//                    }
//                }
//            }
//        }
//    }
//
//
//}
