package com.xiewendomg.admin.interview.java;

import java.util.*;

/**
 * Collection  LIST SET MAP 疑问
 */
public class CollectionTest {
    public static void main(String[] args) {
        testHashSet();
    }

    private static void testHashSet() {
        Map map = new HashMap();
        map.put("1", 2);
        map.put("1", 3);
        System.out.println(map.put("1", 5));
    }
}
