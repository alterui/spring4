package com.oyo.demo0925;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/9/25 11:09
 */
public class Application {
    public static void main(String[] args) {
        List<Integer> details = new ArrayList<>();
        //details.add(1);
        //details.add(5);
        details.add(0);

        List<Integer> collect = details.stream().filter(bill -> bill == 0).collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(collect)) {
            System.out.println(collect);
        }
    }
}
