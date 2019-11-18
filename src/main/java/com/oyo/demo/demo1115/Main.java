package com.oyo.demo.demo1115;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author liurui
 * @date 2019/11/15 20:08
 */
public class Main {
    public static void main(String[] args) {


        List<ChannelBO> channelBOList = Lists.newArrayList();
        ChannelBO bo = new ChannelBO();
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(5);

        bo.setList(list);
        bo.setAge(1);

        channelBOList.add(bo);

        ChannelBO bo1 = new ChannelBO();
        List<Integer> list1 = Lists.newArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(5);

        bo1.setList(list1);
        bo1.setAge(2);

        channelBOList.add(bo1);




        channelBOList.forEach(e->{
            if (e.getAge() == 2) {
                e.setAge(9);
            }
        });

        channelBOList.forEach(System.out::println);




    }
}
