package com.huangxw.fifty.exception;

import java.io.Serializable;

/**
 * 处理异常方式一：Result手动封装
 */
public class Result<T> implements Serializable {
    
    private Integer code;
    private String message;
    private T data;
    
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    /**
     * 带数据成功返回
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ExceptionCodeNum.SUCCESS.getCode(),ExceptionCodeNum.SUCCESS.getDesc(),data);
    }
    
    /**
     * 不带数据成功返回
     */
    public static <T> Result<T> success() {
        return success(null);
    }
    
    /**
     * 通用错误返回，传入指定的错误枚举
     */
    public static <T> Result<T> error(ExceptionCodeNum exceptionCodeNum) {
        return new Result<>(exceptionCodeNum.getCode(),exceptionCodeNum.getDesc());
    }
    
    /**
     * 通用错误返回，传入指定的错误枚举，但支持覆盖message
     */
    public static <T> Result<T> error(ExceptionCodeNum exceptionCodeNum,String msg) {
        return new Result<>(exceptionCodeNum.getCode(),msg);
    }
    
    /**
     * 通用错误返回，只传入message
     */
    public static <T> Result<T> error(String msg) {
        return new Result<>(ExceptionCodeNum.ERROR.getCode(),msg);
    }
    
}
