package com.xiewendomg.admin.java;

public class ArrayDemo {
    public static void main(String[] args) {
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