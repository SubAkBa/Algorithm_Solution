package org.example;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] {33, 6, 2, 3, 7, 86, 89, 223, 23, 74};

		bubbleSort(arr);

		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; ++i) {
			for (int j = 0; j < arr.length - 1 - i; ++j) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
