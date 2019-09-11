package com.xiewendomg.admin.dataStructure.math;

import java.util.Arrays;

public class ClassicSort {
    public static void main(String[] args) {
        ClassicSort cs = new ClassicSort();
        cs.insertion_sort();
        cs.selection_sort();
        cs.bubble_sort();
        cs.quick_sort();
    }

    /**
     * 插入
     */
    void insertion_sort() {
        int[] a = new int[]{2, 4, 1, 4, 6, 8, 5, 3};
        int n = a.length;
        int i, j, v;
        for (i = 1; i < n; i++) {
            for (v = a[i], j = i - 1; j >= 0 && v < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = v;
        }

        System.out.println(Arrays.toString(a));
    }

    /**
     * 选择排序
     */
    void selection_sort() {
        int[] a = new int[]{2, 4, 1, 4, 6, 8, 5, 3};
        int n = a.length;
        int i, j, pos, tmp;
        for (i = 0; i < n - 1; i++) {
            //寻找最小值的下标
            for (pos = i, j = i + 1; j < n; j++) {
                if (a[pos] > a[j])
                    pos = j;
            }
            if (pos != i) {
                tmp = a[i];
                a[i] = a[pos];
                a[pos] = tmp;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 冒泡排序
     */
    void bubble_sort () {
        int[] a = new int[]{2, 4, 1, 4, 6, 8, 5, 3};
        int n = a.length;
        int i, j, lastSwap, tmp;
        for (j=n-1; j>0; j=lastSwap) {
            lastSwap=0;     //每一轮要初始化为0，防止某一轮未发生交换，lastSwap保留上一轮的值进入死循环
            for (i=0; i<j; i++) {
                if (a[i] > a[i+1]) {
                    tmp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=tmp;
                    //最后一次交换位置的坐标
                    lastSwap = i;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    int mpartition(int a[], int l, int r) {
        int pivot = a[l];

        while (l<r) {
            while (l<r && pivot<=a[r]) r--;
            if (l<r) a[l++]=a[r];
            while (l<r && pivot>a[l]) l++;
            if (l<r) a[r--]=a[l];
        }
        a[l]=pivot;
        return l;
    }

    void quick_sort () {
        int[] a = new int[]{2, 4, 1, 4, 6, 8, 5, 3};
        int l=6; int r=a.length-1;
        if (l < r) {
            int q = mpartition(a, l, r);
            System.out.println(q);
           /* mpartition(a, l, q-1);
            mpartition(a, q+1, r);*/
        }
        System.out.println(Arrays.toString(a));
    }
}
