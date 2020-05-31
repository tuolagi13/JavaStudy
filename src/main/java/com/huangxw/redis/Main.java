package com.huangxw.redis;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Main {


    public static void main(String[] args) {
//        List<String> list = Arrays.asList("A","B","C","D");
//        Stream<String> stream =list.stream();
//        stream.forEach(System.out::println);
        List<Book> books =Arrays.asList(
                new Book("Java编程思想", "Bruce Eckel", "机械工业出版社", 108.00D),
                new Book("Java 8实战", "Mario Fusco", "人民邮电出版社", 79.00D),
                new Book("MongoDB权威指南（第2版）", "Kristina Chodorow", "人民邮电出版社", 69.00D)
        );
        System.out.println(books.stream().collect(counting()));

    }
}

class Book{
    private String name;
    private String author;
    private String publish;
    private double price;

    public Book(String name, String author, String publish, double price) {
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.price = price;
    }
}