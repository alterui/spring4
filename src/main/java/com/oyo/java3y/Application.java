package com.oyo.java3y;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liurui
 * @date 2019/12/16 17:38
 */
public class Application {
    public static void main(String[] args) {


        List<String> list = new ArrayList<>(1);
       // System.out.println(list.size());
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("1");
        list.add(3, "22");

        //list.forEach(System.out::println);

        int[] arr = new int[10];
        arr[7] = 1;
        for (int value : arr) {
           // System.out.println(value);
        }




        HashMap<String,String> map = new HashMap<>((1<<29)-3);
        map.put("1","1");
        System.out.println(map.size());











    }
}
