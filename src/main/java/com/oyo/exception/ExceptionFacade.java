package com.oyo.exception;

import com.oyo.bike.GetBike;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liurui
 * @date 2019/9/20 18:30
 */
public class ExceptionFacade implements ExceptionClient {
    @Autowired
    GetBike getBike;

    @Override
    public void userBike() {
        getBike.getBike();
    }

    public static void main(String[] args) {
        ExceptionFacade exceptionFacade = new ExceptionFacade();

        try {
            exceptionFacade.userBike();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
