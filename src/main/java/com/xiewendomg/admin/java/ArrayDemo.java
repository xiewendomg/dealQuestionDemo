package com.xiewendomg.admin.java;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;

public class ArrayDemo {
    private static int count=1;
    public static void main(String[] args) {

        Set<Object> set=new TreeSet<Object>();



        //会报错
        set.add(4);
        set.add("5");
        set.add(2);
        set.add(new Date());


        for (Object s:set){
            System.out.println(s);
        }

        count+=10;
        System.out.println(count);

        //定义第一个数组
        int[] arr = new int[3];
        arr[0] = 88;
        arr[1] = 33;
        arr[2] = 66;
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println("----");
        //定义第二个数组
        int[] arr2 = new int[3];
        arr2[0] = 22;
        arr2[1] = 44;
        arr2[2] = 55;
        System.out.println(arr2);
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        System.out.println(arr2[2]);
        System.out.println("----");
        //定义第三个数组
        int[] arr3 = arr;
        arr3[0] = 100;
        arr3[1] = 200;
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}