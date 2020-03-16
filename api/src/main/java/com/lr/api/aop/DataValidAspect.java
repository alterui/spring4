package com.lr.api.aop;

import com.lr.api.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author liurui
 * @date 2020/3/16 9:43
 */

@Aspect
@Component
@Slf4j
public class DataValidAspect {

    @Around("execution(* com.lr.api.controller.*Controller.*(..))")
    public Object validAround(ProceedingJoinPoint point) {

        Object proceed = null;
        log.info("切面开始执行了");

        for (Object obj : point.getArgs()) {
            if (obj instanceof BindingResult) {
                BindingResult result = (BindingResult) obj;

                if (result.getErrorCount() > 0) {
                    StringBuilder sb = new StringBuilder();
                    List<ObjectError> allErrors = result.getAllErrors();
                    allErrors.forEach(e -> sb.append(e.getDefaultMessage()).append(" "));
                    return BaseResponse.fail("101", sb.toString());
                }
            }
        }

        try {
            proceed = point.proceed(point.getArgs());


        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }finally {
            log.info("aop方法执行完毕...");
        }
        return proceed;
    }
}
