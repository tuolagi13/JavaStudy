package com.huangxw.fifty.validate;

import sun.security.validator.ValidatorException;

import javax.xml.bind.ValidationException;

/**
 * 参数判断+抛异常+全局异常处理
 */
public class ValidatorUtil {
    //错误信息模板
    private static final String IS_EMPTY = "%s不能为空";
    private static final String LESS_THAN_ZERO = "%s不能小于0";
    
    /**
     * 判断参数是否为null
     */
    public static void checkNull(Object param, String fieldName) throws ValidatorException {
        if(param == null)
        {
            //ValidatorException是自定义异常
            throw new ValidatorException(String.format(IS_EMPTY,fieldName));
        }            
    }
    
    /**
     * 校验id是否合法
     */
    public static void checkId(Long id, String fieldName) throws ValidatorException {
        if (id == null) {
            throw new ValidatorException(String.format(IS_EMPTY, fieldName));
        }
        if (id < 0) {
            throw new ValidatorException(String.format(LESS_THAN_ZERO, fieldName));
        }
    }
}
