package org.example;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = new int[] {33, 6, 2, 3, 7, 86, 89, 223, 23, 74};

		radixSort(arr, 3);

		System.out.println(Arrays.toString(arr));
	}

	public static void radixSort(int[] arr, int maxSize) {
		int jarisu = 1, size = 0;
		int len = arr.length;
		int[] output = new int[len];

		while (size < maxSize) {
			int[] bucket = new int[10];

			for (int i = 0; i < len; ++i) {
				++bucket[arr[i] / jarisu % 10];
			}

			for (int i = 1; i < 10; ++i) {
				bucket[i] += bucket[i - 1];
			}

			for (int i = len - 1; i >= 0; --i) {
				int idx = arr[i] / jarisu % 10;

				output[bucket[idx] - 1] = arr[i];
				--bucket[idx];
			}

			for (int i = 0; i < len; ++i) {
				arr[i] = output[i];
			}

			jarisu *= 10;
			++size;
		}
	}
}
