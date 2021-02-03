package com.huangxw.fifty.JPA;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Type;

public class JPATest {
    
    public static void main(String[] args) {
        B b = new B();
    }
}


class A<T> {
    public A() {
        Class<? extends A> subClass = this.getClass();
        //得到泛型父类
        Type genericSuperClass = subClass.getGenericSuperclass();
        //本质是ParameterizedTypeImpl,可以向下强转
        ParameterizedTypeImpl parameterizedTypeSuperClass = (ParameterizedTypeImpl)genericSuperClass;
        //强转后可用方法变多了，比如getActualTypeArguments()可以获取class A<String>的泛型实际参数
        Type[] types = parameterizedTypeSuperClass.getActualTypeArguments();
        //由于A只有一个泛型类型，可直接通过types[0]得到子类传递的实际类型参数
        Class actualTypeArgument = (Class)types[0];
        System.out.println(actualTypeArgument);
        System.out.println(subClass.getName());
    }
}

class B extends A<String> {
    
}

class C extends A<Integer> {
    
}