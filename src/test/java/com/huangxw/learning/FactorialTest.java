package com.huangxw.learning;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    @Test
    void testFact(){
        Assertions.assertEquals(1,Factorial.fact(1));
        Assertions.assertEquals(2,Factorial.fact(2));
        Assertions.assertEquals(6,Factorial.fact(3));
        Assertions.assertEquals(3628800,Factorial.fact(10));
        Assertions.assertEquals(2432902008176640000L,Factorial.fact(20));
    }
}
