package com.oyo.car;

import com.oyo.exception.ServiceException;
import org.springframework.stereotype.Component;

/**
 * @author liurui
 * @date 2019/9/20 18:43
 */
@Component
public class GetBMWCat implements GetCar {
    @Override
    public void getCar() {
        Integer a = 0;
        Integer b = null;

        try {
            int c = a+b;
           // ServiceException serviceException = ServiceException.builder().msg("asdasd").build();
        } catch (NullPointerException e) {
            throw ServiceException.builder().msg("json串不能为空").build();
        }
    }
}
