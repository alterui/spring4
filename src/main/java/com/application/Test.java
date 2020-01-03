package com.application;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liurui
 * @date 2019/12/30 21:38
 */
public class Test {
    public static void main(String[] args) {

        String s = "a" +
                "aa";
        int i = lengthOfLongestSubstring(s);
        System.out.println("结果是" + i);

        Map<Character, Integer> map = new HashMap<>();
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            System.out.println("i:"+i);
            ans = Math.max(ans, j - i + 1);
            System.out.println("ans:"+ans);

            index[s.charAt(j)] = j + 1;
            System.out.println("index[s.charAt("+j+")] :"+ index[s.charAt(j)] );

            System.out.println("=====================");

        }
        return ans;
    }
}
