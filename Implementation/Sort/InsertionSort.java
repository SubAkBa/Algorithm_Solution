package org.example;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = new int[] {33, 6, 2, 3, 7, 86, 89, 223, 23, 74};

		insertionSort(arr);

		System.out.println(Arrays.toString(arr));
	}

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; ++i) {
			int idx = i - 1;
			int value = arr[i];

			while (idx >= 0 && arr[idx] > value) {
				arr[idx + 1] = arr[idx];
				--idx;
			}

			arr[idx + 1] = value;
		}
	}
}
