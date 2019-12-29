package com.oyo.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liurui
 * @date 2019/12/29 9:59
 */
public class Test {
    public static void main(String[] args) {

        int i = lengthOfLongestSubstring("c");
        System.out.println(i);
    }


    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.trim().equals("")){
            return 1;
        }
        int result = 0;
        for(int i = 0 ; i < s.length();i++){
            for(int j = i +1;j< s.length();j++){
                if(check(s,i,j)){
                    result = Math.max(result,j-i);
                }
            }
        }
        return result;
    }

    public static boolean check(String s ,int i ,int j){
        Set<Character> set = new HashSet<>();
        for( int k =i;k<j;k++){
            if(set.contains(s.charAt(k))){
                return false;
            }
            set.add(s.charAt(k));
        }
        return true;
    }

}
