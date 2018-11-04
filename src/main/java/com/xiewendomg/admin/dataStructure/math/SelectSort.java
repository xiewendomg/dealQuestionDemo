package com.xiewendomg.admin.dataStructure.math;

import java.util.Arrays;

/**
 * 选择排序.
 */
public class SelectSort {

    public void selectSort(int[] array){
        for (int i=0;i<array.length;i++){
            int min=array[i];
            int minId=i;
            for (int j=i;j<array.length;j++){
                if (array[j]<min){
                    min=array[j];
                    minId=j;
                }
            }
            array[minId]=array[i];
            array[i]=min;

        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,3,6,4,7,9,5};
        SelectSort s=new SelectSort();
        s.selectSort(array);
    }
}
