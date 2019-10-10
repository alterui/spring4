package com.oyo.spring4.aop;

import com.alibaba.fastjson.JSON;
import com.oyo.common.BaseResponse;
import com.oyo.common.ResponseCode;
import com.oyo.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 统一方法注解捕获异常
 *
 * @author liurui
 * @date 2019/10/10 11:12
 */
@Slf4j
@Aspect
@Component
public class ExceptionAspect {
    @Around(value = "@annotation(com.oyo.spring4.aop.ExceptionCatch)")
    public Object interceptor(ProceedingJoinPoint joinPoint) throws Throwable{
        Object target = joinPoint.getTarget();
        String className = target.getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        String prefix = new StringBuffer().append(className).append("#").append(methodName).append(" ").toString();
        log.info(prefix + "params={}", JSON.toJSONString(args));
        Object result = null;
        try {
            result = joinPoint.proceed();
            log.info(prefix + "response={}", JSON.toJSONString(result));
        } catch (IllegalArgumentException e) {
            log.info(prefix + "illegal argument", e);
            return BaseResponse.fail(ResponseCode.ILLEGAL_ARGUMENT);
        } catch (ServiceException e) {
            log.info(prefix + "service exception", e);
            return BaseResponse.fail(e.getCode(), e.getMsg());
        } catch (Exception e) {
            log.info(prefix + "error", e);
            return BaseResponse.fail(ResponseCode.FAILURE);
        }
        return result;
    }
}
