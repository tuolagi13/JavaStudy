package com.huangxw.fifty.exception;

/**
 * 业务异常
 */
public class BizException extends RuntimeException {
    
    private ExceptionCodeNum error;
    
    /**
     * 构造器，有时我们需要将第三方异常转为自定义异常抛出，但又不想丢失原来的异常信息，此时可以传入cause
     */
    public BizException(Throwable cause, ExceptionCodeNum error) {
        super(cause);
        this.error = error;
    }
    
    public BizException(ExceptionCodeNum error) {
        this.error = error;
    }
    
}
