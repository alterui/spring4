package com.oyo.spring4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class AnnotationDemo {

    @Test
    public static void testDemo1() {
        log.info("This is test method.");
    }

    @Deprecated
    @SuppressWarnings("uncheck")
    public static void testDemo2() {

    }
}
