package com.oyo.exe;

public class Application {
    public static void main(String[] args) {
        String date = "  ~  ";

        String date1 = "2017-10-06~2017-10-07";

        String[] checkInOutTime = date.split("~");
        String[] checkInOutTime2 = date.split("~");

        System.out.println(checkInOutTime.length);
        System.out.println(checkInOutTime[0]);


        if (checkInOutTime.length == 2) {
            System.out.println(checkInOutTime[0]);
        }

    }
}
