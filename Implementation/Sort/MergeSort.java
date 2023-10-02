package org.example;

import java.util.Arrays;

public class MergeSort {

	static int[] temp;

	public static void main(String[] args) {
		int[] arr = new int[] {33, 6, 2, 3, 7, 86, 89, 223, 23, 74};
		int len = arr.length;
		temp = new int[len];

		mergeSort(arr, 0, len - 1);

		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;

			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		for (int i = left; i <= right; ++i) {
			temp[i] = arr[i];
		}

		int l = left, r = mid + 1;
		int idx = left;

		while (l <= mid && r <= right) {
			if (temp[l] > temp[r]) {
				arr[idx++] = temp[r++];
			} else {
				arr[idx++] = temp[l++];
			}
		}

		while (l <= mid) {
			arr[idx++] = temp[l++];
		}

		while (r <= right) {
			arr[idx++] = temp[r++];
		}
	}
}
