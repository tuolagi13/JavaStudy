package com.huangxw.fifty.stream;


/**
 * MyPredict是模拟Predict
 * MyInteger是模拟Integer
 * 本次测试的目的旨在说明，Lambda毕竟是手写的，自由度和颗粒度要高于方法引用
 */
public class MethodAndLambdaTest {
    
    public static void main(String[] args) {
        //1.匿名对象
        MyPredict myPredict1 = new MyPredict() {
            @Override
            public boolean test(int a, int b) {
                return a - b > 0;
            }
        };
        boolean result1 = myPredict1.test(1,2); //false
        
        //2.从匿名对象过渡到Lambda表达式
        MyPredict myPredict2 = (a,b) -> a - b > 0;
        boolean result2 = myPredict2.test(1,2);
        
        //3.MyInteger#compare()方法体和上面的Lambda表达式逻辑相同，可以直接引用
        MyPredict myPredict3 = MyInteger::compare;
        boolean result3 = myPredict3.test(1,2);
        
        //4.Lambda表达式 DIY规则
        MyPredict myPredict4 = (a,b) -> a - b < 0;
        myPredict4.test(1,2);
        
        //5.看到这，方法引用无法DIY，方法引用是把MyInteger::compare整个方法搬过来，不能修改内部逻辑
        MyPredict myPredict5 = MyInteger::compare;
        
    }
}


interface MyPredict {
    boolean test(int a,int b);
}

interface MyInteger {
    public static boolean compare(int a,int b) {
        return a - b > 0;
    }
}
