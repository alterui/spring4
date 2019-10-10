package com.oyo.spring4.aop;

import java.lang.annotation.*;

/**
 * 统一方法注解捕获异常
 *
 * @author liurui
 * @date 2019/10/10 11:10
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionCatch {
}
