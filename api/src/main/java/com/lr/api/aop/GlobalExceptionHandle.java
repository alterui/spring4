package com.lr.api.aop;

import com.lr.api.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liurui
 * @date 2020/3/16 10:48
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = {ArithmeticException.class})
    public Object exceptionHandle(Exception exception) {
        log.error("出现异常{}", exception.getStackTrace());
        return BaseResponse.fail("007", "数学异常");
    }

}
