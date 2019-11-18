package com.oyo.demo.demo1024;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Test  {
    public static void main(String[] args) {
        List<String> putAway = Lists.newArrayList();


        Channel channel = new Channel();
        channel.setPutAway(putAway);

        List<String> all = Lists.newArrayList();
        all.add("美团");
        all.add("携程");
        all.add("艺龙");
        all.add("飞猪");

        if (CollectionUtils.isEmpty(channel.getPutAway())) {
           all.forEach(System.out::println);

        } else {
            List<String> c = all.stream().filter(e -> !channel.getPutAway().contains(e)).collect(Collectors.toList());
            c.forEach(System.out::println);
        }



    }
}
