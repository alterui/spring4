package com.oyo.apply;

import java.util.function.Function;

/**
 * @author liurui
 * @date 2019/9/25 20:19
 */
public abstract class AbstractFacadeImpl {
    public static int invoke(Integer request, Function<Integer, Integer> function) {
        return function.apply(request);
    }
}
