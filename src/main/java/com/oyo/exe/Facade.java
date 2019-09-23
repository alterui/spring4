package com.oyo.exe;

import com.oyo.car.GetCar;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liurui
 * @date 2019/9/20 18:43
 */
public class Facade implements Client {

    @Autowired
    GetCar getCar;

    @Override
    public void getExe() {
        getCar.getCar();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        try {
            facade.getExe();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
