package com.xiewendomg.admin.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTest {
    final static String A="safds";
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("6", "1", "3", "1", "2");
        Collections.sort(strings);//sort方法在这里 for (String string : strings) { System.out.println(string); } }

        System.out.println("ab".hashCode());

        String a="sfs";
        System.out.println((Object) a.toString());
    }
}