package com.oyo.hashmap;

import com.oyo.demo.demo1029.Student;

import java.util.*;

/**
 * @author liurui
 * @date 2019/12/27 16:40
 */
public class Application {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(5);
        list.add(3);

        Map hashMap = new HashMap();

      //  System.out.println(1%10);

        int i = lengthOfLongestSubstring("pwwkew");
        System.out.println(i);


        String s = "";

        s.length();

        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(2, 23);
        treeMap.put(1, 2);
        treeMap.put(3, 34);


        treeMap.forEach((k,v)-> System.out.println("K:" + k + " V:" + v ));

        int i0 = "b".compareTo("a");
        System.out.println("长度："+i0);

        Map<Student, String> map = new TreeMap<Student, String>((o1, o2) -> {
            //主要条件
            int num = o1.getAge() - o2.getAge();

            //次要条件
            int num2 = num == 0 ? o1.getName().compareTo(o2.getName()) : num;

            return num2;
        });


    }

    public static int lengthOfLongestSubstring(String s) {
        String[] str =  s.split("");
        Set set = new HashSet();
        for(int i = 0 ;i<str.length;i++){
            set.add(str[i]);
        }

        return set.size();
    }
}
