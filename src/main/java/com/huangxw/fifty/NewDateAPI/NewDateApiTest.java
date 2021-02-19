package com.huangxw.fifty.NewDateAPI;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class NewDateApiTest {
    
    public static void main(String[] args) {
        
        //新的date方式，只能通过给定方法获取
        LocalDate newDate = LocalDate.now();
        LocalTime newTime = LocalTime.now();
        LocalDateTime newDateTime = LocalDateTime.now();
        System.out.println("newDate : " + newDate);
        System.out.println("newTime : " + newTime);
        System.out.println("newDateTime : " + newDateTime);
        
        //可以组合
        LocalDateTime combineDateTime = LocalDateTime.of(newDate,newTime);
        System.out.println("combineDateTime : " + combineDateTime);
        
        //创建指定时间
        LocalDate customDate = LocalDate.of(2021,02,19);
        LocalTime customTime = LocalTime.of(9,53,2);
        LocalDateTime customDateTime = LocalDateTime.of(2021,2,19,9,54,44);
        System.out.println("customDate : " + customDate);
        System.out.println("customTime : " + customTime);
        System.out.println("customDateTime : " + customDateTime);
        
        //获取时间参数的年月日(有时需求要用到)
        System.out.println("获取时间参数的年、月、日：");
        LocalDateTime param = LocalDateTime.now();
        System.out.println("year:" + param.getYear());
        System.out.println("month:" + param.getMonth());
        System.out.println("day:" + param.getDayOfMonth());
        System.out.println("hour:" + param.getHour());
        System.out.println("minute:" + param.getMinute());
        System.out.println("second:" + param.getSecond() + "\n");
        
        //计算昨天的同一时刻(由于对象不可修改，所以返回的是新对象)
        System.out.println("计算前一天当前时刻：");
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.plus(-1, ChronoUnit.DAYS);
        System.out.println("today:" + today);
        System.out.println("yesterday:" + yesterday);
        System.out.println("same object:" + today.equals(yesterday) + "\n");
        
        //计算当天0点和24点
        System.out.println("计算当天的00点和24点：");
        LocalDateTime todayBegin = LocalDateTime.of(LocalDate.now(),LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(),LocalTime.MAX);
        System.out.println("todayBegin:" + todayBegin);
        System.out.println("todayEnd:" + todayEnd + "\n");
    
        System.out.println("计算一周、一个月、一年前的当前时刻：");
        LocalDateTime oneWeekAgo = today.minus(1,ChronoUnit.WEEKS);
        LocalDateTime oneMonthAgo = today.minus(1,ChronoUnit.MONTHS);
        LocalDateTime oneYearAgo = today.minus(1,ChronoUnit.YEARS);
        System.out.println("oneWeekAgo" + oneWeekAgo);
        System.out.println("oneMonthAgo" + oneMonthAgo);
        System.out.println("oneYearAgo" + oneYearAgo + "\n");
        
        //时区(id的形式，默认是本国时区)
        ZoneId zoneId = ZoneId.systemDefault();
        //为localDateTime补充时区信息
        ZonedDateTime beijingTime = today.atZone(zoneId);
        System.out.println("beijingTime: " + beijingTime);
        
        //格式化
        String format = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        System.out.println("格式化后：" + format);
        
        
        
    }
}
