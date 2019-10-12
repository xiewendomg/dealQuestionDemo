package com.xiewendomg.admin.interview.java;

import java.util.*;

/**
 * Collection  LIST SET MAP 疑问
 */
public class CollectionTest {
    public static void main(String[] args) {
        testHashSet();
    }

    private String name;

    public CollectionTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static void testHashSet() {
        Map map = new HashMap();
        map.put("1", 2);
        map.put("1", 3);
        System.out.println(map.put("1", 5));

        List<CollectionTest> list = new ArrayList();
        CollectionTest test1 = new CollectionTest("小红");
        list.add(test1);
        CollectionTest test2 = new CollectionTest("小明");
        list.add(test2);
        CollectionTest[] array = new CollectionTest[2];
        array = list.toArray(array);
        System.out.println(array[0].name);
        test1.setName("红红");
        System.out.println(array[0].name);
        Arrays.asList(array);
    }
}
