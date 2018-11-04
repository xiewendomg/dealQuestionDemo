package com.xiewendomg.admin.dataStructure.math;

import java.util.Arrays;

/**
 * 二分法插入排序
 * 
 * @author Administrator
 *
 */
public class BinaryInsertSort {

	public static void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int low = 0;
			int high = i - 1;
			int tmp = array[i];
			while (low <= high) {
				int mid = (high + low) >> 1;
				if (array[mid] < tmp) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			for (int j = i - 1; j >= low; j--) {
				array[j + 1] = array[j];
			}
			array[low] = tmp;
		}
		System.out.println(Arrays.toString(array));

	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 34, 67, 3, 5, 8, 2, 9 };
		sort(array);
	}
}
