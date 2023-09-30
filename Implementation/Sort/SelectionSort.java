package org.example;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[] {33, 6, 2, 3, 7, 86, 89, 223, 23, 74};

		selectionSort(arr);

		System.out.println(Arrays.toString(arr));
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			int minIdx = i;

			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}

			swap(arr, i, minIdx);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
