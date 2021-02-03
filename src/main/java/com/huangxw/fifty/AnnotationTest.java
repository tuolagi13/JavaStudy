package com.huangxw.fifty;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyAnnotation(getValue = "annotation on class")
public class AnnotationTest {
    
    @MyAnnotation(getValue = "annotation on field")
    public String name;
    
    @MyAnnotation(getValue = "annotation on method")
    public void hello(){}
    
    @MyAnnotation
    public void defaultMethod(){}
    
    
    public static void main(String[] args) throws Exception {
        Class<AnnotationTest> clazz = AnnotationTest.class;
        MyAnnotation annotationClass = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotationClass.getValue());
        
        Field name = clazz.getField("name");
        MyAnnotation annotationField = name.getAnnotation(MyAnnotation.class);
        System.out.println(annotationField.getValue());
        
        Method hello = clazz.getMethod("hello",(Class<?>[])null);
        MyAnnotation annotationMethod = hello.getAnnotation(MyAnnotation.class);
        System.out.println(annotationMethod.getValue());
    
        Method defaultMethod = clazz.getMethod("defaultMethod",(Class<?>[])null);
        MyAnnotation annotationDeMethod = defaultMethod.getAnnotation(MyAnnotation.class);
        System.out.println(annotationDeMethod.getValue());
        
    }
}
