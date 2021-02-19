package com.huangxw.fifty.Enum;

import lombok.Getter;

@Getter
public enum WeekDayEnum {
    
    
    MONDAY(1,"星期一"),
    TUESDAY(1,"星期二"),
    WEDNESDAY(1,"星期三"),
    THURSDAY(1,"星期四"),
    FRIDAY(1,"星期五"),
    SATURDAY(1,"星期六"),
    SUNDAY(1,"星期日");
    
    // 标记最终把code作为枚举值插入数据库
    @EnumValue
    private final Integer code;
    private final String desc;
    
    WeekDayEnum(Integer code,String desc) {
        this.code = code;
        this.desc = desc;
    }
}
