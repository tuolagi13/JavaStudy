package com.huangxw.learning;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@DisplayName("我的第一个测试用例")
public class MyFirstTestCaseTest {

    @BeforeAll
    public static void init(){
        System.out.println("初始化数据");
    }

    @AfterAll
    public static void cleanup(){
        System.out.println("清理数据");
    }

    @BeforeEach
    public void tearup(){
        System.out.println("当前测试方法开始");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("当前测试方法结束");
    }

    @DisplayName("我的第一个测试")
    @Test
    void testFirstTest(){
        System.out.println("我的第一个测试开始");
    }

    @DisplayName("我的第二个测试")
    @Test
    void testSecondTest(){
        System.out.println("我的第二个测试开始");
    }

    @DisplayName("我的第三个测试")
    @Disabled
    @Test
    void testThirdTest() {
        System.out.println("我的第三个测试开始测试");
    }

    @DisplayName("重复测试")
    @RepeatedTest(value = 3, name = "{displayName} 第 {currentRepetition} 次")
    public void i_am_a_repeated_test() {
        System.out.println("执行重复测试");
    }

    @DisplayName("断言测试")
    @Test
    void testGroupAssertions(){
        int[] numbers = {0,1,2,3,4};
        Assertions.assertAll("numbers",
                () -> Assertions.assertEquals(numbers[1],1),
                () -> Assertions.assertEquals(numbers[2],2),
                () -> Assertions.assertEquals(numbers[3],3),
                () -> Assertions.assertEquals(numbers[4],4)
        );
    }

    @DisplayName("超时方法测试")
    @Test
    void test_should_complete_in_one_second(){
        Assertions.assertTimeoutPreemptively(Duration.of(1, ChronoUnit.SECONDS),
                () -> Thread.sleep(1000));
    }

    @DisplayName("捕获异常测试")
    @Test
    void assertThrowExceptions(){
        String str = null;
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.valueOf(str);
        });
    }

}
