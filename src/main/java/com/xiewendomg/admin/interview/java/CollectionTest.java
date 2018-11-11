package com.xiewendomg.admin.interview.java;

import java.util.*;

/**
 * Collection  LIST SET MAP 疑问
 */
public class CollectionTest {
    public static void main(String[] args) {
        testHashSet();
    }

    private static void testHashSet(){
        Set hashSet=new HashSet();
        hashSet.add(null);
        hashSet.add("胖子");
        hashSet.add(null);
        System.out.println(hashSet);
        new HashMap<>();
    }
}
