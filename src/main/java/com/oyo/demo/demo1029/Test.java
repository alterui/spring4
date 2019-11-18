package com.oyo.demo.demo1029;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author liurui
 * @date 2019/11/14 19:51
 */
public class Test {

    public static void main(String[] args) {



        List<Integer> list = Lists.newArrayList();
        Dog dog = new Dog();
        dog.setDogList(list);

        list.add(1);

        System.out.println(dog.getDogList());


    }


}

@Data
class Dog{
    private List<Integer> dogList;
}
