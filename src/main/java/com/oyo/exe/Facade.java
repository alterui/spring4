package com.oyo.exe;

import com.oyo.car.GetBMWCat;
import com.oyo.car.GetCar;
import com.oyo.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liurui
 * @date 2019/9/20 18:43
 */
public class Facade implements Client {

    GetCar getCar = new GetBMWCat();

    @Override
    public void getExe() {
        getCar.getCar();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        try {
            facade.getExe();
        } catch (ServiceException e) {
            System.out.println("11111111");
            System.out.println(e.getCode()+e.getMsg());
        } catch (RuntimeException e) {

            System.out.println("a");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("3333");
        }
    }
}
