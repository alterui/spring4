package com.oyo.easyexcel;


import com.alibaba.excel.EasyExcel;

public class SimpleRead {
    public static void main(String[] args) {
        String fileName = "/Users/oyo/Downloads/test.xlsx";
        EasyExcel.read(fileName,DemoData.class,new WriteWithoutHead()).sheet().doRead();

    }
}
