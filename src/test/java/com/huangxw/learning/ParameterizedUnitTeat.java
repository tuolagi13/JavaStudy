package com.huangxw.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * junt参数化测试
 */
public class ParameterizedUnitTeat {

    @ParameterizedTest
    @ValueSource(ints = {2,4,8})
    void testNumberShouldBeEven(int num){
        Assertions.assertEquals(0,num % 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Effective Java", "Code Complete", "Clean Code"})
    void testPrintTitle(String title){
        System.out.println(title);
    }

    //CSV 数据源测试：@CsvSource
    @ParameterizedTest
    @CsvSource({"1,One", "2,Two", "3,Three"})
    void testDataFromCSV(long id,String name){
        System.out.printf("id: %d, name: %s", id, name);
    }
}
