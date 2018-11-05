package com.xiewendomg.admin.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试hashMap 扩容机制
 */
public class HashMapTest {

    public static void main(String[] args) throws Throwable {
        testHashMap();
        new HashMapTest().finalize();
    }


    /**
     * 测试
     */
    private static  void  testHashMap(){
        Map map=new HashMap(4);
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");
        map.put(4,"4");
        map.put(5,"5");
    }

    /**
     *   |= 位运算 或运算符
     */
    private static  void  math(){
        int n = 12 - 1;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(n &= n >>> 1);
        System.out.println(n |= n >>> 2);
        System.out.println(n |= n >>> 4);
        System.out.println(n |= n >>> 8);
        System.out.println(n |= n >>> 16);
        System.out.println(n>>> 2);
        System.out.println(n>>> 4);
        System.out.println(n>>> 8);
        System.out.println(n>>> 16);

        System.out.println( -8 >> 1);
        System.out.println( -8 >>> 1);
    }
}
