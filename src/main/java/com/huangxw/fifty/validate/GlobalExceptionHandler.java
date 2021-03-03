package com.huangxw.fifty.validate;


import com.huangxw.fifty.exception.ExceptionCodeNum;
import com.huangxw.fifty.exception.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sun.security.validator.ValidatorException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /* 省略业务异常、运行时异常处理 */
    
    @ExceptionHandler(ValidatorException.class)
    public Result<ExceptionCodeNum> handleValidatorException(ValidatorException e) {
        //打印精确的参数错误日志，方便后端排查
        System.out.println("参数校验异常");
        //一般来说，给客户端展示"参数错误"等泛化的错误信息即可，联调时可返回精确的信息 e.getMessage()
        return Result.error(ExceptionCodeNum.ERROR_PARAM);
    }
    
}
