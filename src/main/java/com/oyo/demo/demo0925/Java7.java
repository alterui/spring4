package com.oyo.demo.demo0925;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/9/25 11:52
 */
public class Java7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("spring", "node", "ricky");

        List<String> spring = list.stream().filter(line -> line.equals("spring")).collect(Collectors.toList());

        // List<String> spring = getFilterOutput(list, "spring");
        spring.forEach(System.out::println);

    }

    public static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (filter.equals(line)) {
                result.add(line);
            }
        }
        return result;
    }


}
