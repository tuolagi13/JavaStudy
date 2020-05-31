package com.huangxw.learning;

public class Animal {
    public String noise()
    {
        return "peep";
    }
    





    public static void main(String[] args) {
        Animal animal = new Dog();
        //Cat cat = (Cat) animal;
        System.out.println(animal.noise());
    }
}

class Dog extends Animal {
    public String noise(){
        return "bark";
    }
}

class Cat extends Animal {
    public String noise(){
        return "meow";
    }
}