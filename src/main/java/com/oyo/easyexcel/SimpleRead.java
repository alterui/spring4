package com.oyo.easyexcel;


import com.alibaba.excel.EasyExcel;

import java.util.List;

public class SimpleRead {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\ALTERUI\\Desktop\\test.xlsx";
        EasyExcel.read(fileName,DemoData.class,new WriteWithoutHead()).sheet().doRead();

        List<DemoData> list = WriteWithoutHead.getList();

        list.forEach(System.out::println);

    }
}
