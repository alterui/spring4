package com.oyo.demo0925;

import com.google.common.base.Function;
import com.google.common.base.Stopwatch;
import com.google.common.collect.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/9/25 16:06
 */
public class Guava {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        ArrayList<String> list2 = Lists.newArrayList();
        LinkedList<Object> list3 = Lists.newLinkedList();

        //指定初始大小为100
        List<String> list = Lists.newArrayListWithCapacity(100);
        //把list集合按照一组10个拆分成更小的集合
        List<List<String>> smallList = Lists.partition(list, 10);

        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
        List<Integer> a = list.stream().map(String::hashCode).collect(Collectors.toList());

        //a.forEach(System.out::println);


        List<String> words = Lists.newArrayList();
        words.add("a");
        words.add("a");
        words.add("b");
        words.add("b");
        words.add("b");
        words.add("c");
        words.add("c");
        words.add("d");

        Map<String, Integer> counts = Maps.newHashMap();

        for (String word : words) {
            Integer merge = counts.merge(word, 1, Integer::sum);
            System.out.println(merge);
        }



        for (Map.Entry<String, Integer> map : counts.entrySet()) {
            System.out.println(map.getKey()+":"+map.getValue());
        }


        System.out.println("==========================");






        Multiset<String> multimap = HashMultiset.create();

        for (String word : words) {
            multimap.add(word);
        }
        //multimap.addAll(words);

        for (String word : multimap.elementSet()) {
            int count = multimap.count(word);
            System.out.println(word+":"+count);
        }


        System.out.println("=======================");


        Stopwatch stopwatch = Stopwatch.createUnstarted();
        // 开始计量时间
        stopwatch.start();

        try {
            TimeUnit.MICROSECONDS.sleep(31);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 停止计量时间
        stopwatch.stop();
        // 根据输入时间单位获取相应的时间
        System.out.println(stopwatch.elapsed(TimeUnit.MICROSECONDS));



    }
}
