package com.huangxw.fifty.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MockStream {
    public static void main(String[] args) throws JsonProcessingException {
        MyList<Person> personMyList = new MyList<>();
        personMyList.add(new Person("李健",46));
        personMyList.add(new Person("周深",28));
        personMyList.add(new Person("张学友",59));
    
        MyList<String> collect = personMyList.filter((person) -> person.getAge() > 40).map((person) -> person.getName());
        prettyPrint(collect);
        
    }
    
    
    private static void prettyPrint(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        System.out.println(s);
    }
    
}


@Data
@AllArgsConstructor
class Person {
    private String name;
    private Integer age;
}


@Getter
class MyList<T> {
    private List<T> list = new ArrayList<>();
    
    public boolean add(T t) {
        return list.add(t);
    }
    
    /**
     * 给MyList传递具体的判断规则，然后MyList把内部现有符合判断(true)的元素集返回
     * @param predicate
     * @return
     */
    public MyList<T> filter(Predicate<T> predicate) {
        MyList<T> filteredList = new MyList<>();
        for(T t : list)
        {
            if(predicate.test(t))
                filteredList.add(t);   //收集判断为true的元素
        }
        return filteredList;
    }
    
    /**
     * 把MyList中的List<T>转为List<R>
     * @param mapper
     * @param <R>
     */
    public <R> MyList<R> map(Function<T,R> mapper) {
       MyList<R> rList = new MyList<>();
       for(T t : list)
       {
           rList.add(mapper.apply(t));
       }
       return rList;
    }
}
