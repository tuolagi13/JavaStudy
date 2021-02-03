package com.huangxw.fifty;

import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyJunitFrameWork {
    
    public static void main(String[] args) throws Exception {
        Class clazz = EmployeeDAOTest.class;
        Object obj = clazz.newInstance();
        
        //获取所有公共方法
        Method[] methods = clazz.getMethods();
        
        List<Method> beforeList = new ArrayList<>();
        List<Method> afterList = new ArrayList<>();
        List<Method> testList = new ArrayList<>();
    
       for(Method method : methods)
       {
           if(method.isAnnotationPresent(MyBefore.class))
               beforeList.add(method);
           else if (method.isAnnotationPresent(MyTest.class))
               testList.add(method);
           else if (method.isAnnotationPresent(MyAfter.class))
               afterList.add(method);
       }
       
       //执行方法测试
        for(Method testMethod : testList)
        {
            for(Method beforeMethod : beforeList)
            {
                beforeMethod.invoke(obj);
            }
            testMethod.invoke(obj);
            for(Method afterMethod : afterList)
            {
                afterMethod.invoke(obj);
            }
        }
       
    }
}
