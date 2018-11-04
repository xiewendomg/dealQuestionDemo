package com.xiewendomg.admin.dataStructure.math;

import java.util.Arrays;

/**
 * 排序.
 */
public class InsertSort {

	/**
	 * 直接插入排序
	 */
	public static void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					int tmp = array[i];
					for (int w = i; w > j; w--) {
						array[w] = array[w - 1];
					}
					array[j] = tmp;

				}
			}
			System.out.println(Arrays.toString(array));
		}
	}

	/**
	 * 直接插入排序
	 */
	public static void insertSort2(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int tmp = array[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (array[j] > tmp) {
					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = tmp;

		}
		/*
		 * for (int j = 0; j < i; j++) { if (array[i] < array[j]) { int
		 * tmp=array[i]; for (int w = i; w > j; w--) { array[w] = array[w - 1];
		 * } array[j] = tmp;
		 * 
		 * } }
		 */
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 54, 7, 9, 4 };
		insertSort2(array);
	}
}
