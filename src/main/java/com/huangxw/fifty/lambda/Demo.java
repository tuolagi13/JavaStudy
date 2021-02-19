package com.huangxw.fifty.lambda;
import java.util.Comparator;


public class Demo {
    
    public static void main(String[] args) {
        String str1 = "ab";
        String str2 = "abcd";
        
        //Comparator<String> comparator = (s1,s2) -> s1.length() - s2.length();
        //将上式优化为方法引用
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        
        int k = compareString(str1,str2,comparator);
    }
    
    public static int compareString(String s1,String s2,Comparator<String> comparator) {
        return comparator.compare(s1,s2);
    }
}
