package com.xiewendomg.admin.dataStructure.math;

import com.clearspring.analytics.util.ListNode2;

import java.util.Arrays;

/**
 * 主要利用双指针方法，判断元素是否相同,维护一个【0...slow】的无重复数组或者链表
 */
public class 有序数组和有序链表去重 {
    private static int[] array = new int[]{0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 7, 7, 7, 8, 8, 8, 8};

    public static void main(String[] args) {
        int slow = 0, fast = 1;
        while (fast < array.length) {
            if (array[slow] != array[fast]) {
                slow++;
                array[slow] = array[fast];
            }
            fast++;
        }

        System.out.println(slow + 1);
        System.out.println(Arrays.toString(array));
    }

}
