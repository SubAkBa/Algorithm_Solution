package org.example;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] {33, 6, 2, 3, 7, 86, 89, 223, 23, 74};

		quickSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);

			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}
	}

	public static int partition(int[] arr, int left, int right) {
		if (left > right) {
			if (arr[left] > arr[right]) {
				swap(arr, left, right);
			}

			return right;
		}

		int mid = left + (right - left) / 2;

		swap(arr, left, mid);

		int l = left + 1, r = right;
		int pivot = arr[left];

		while (l <= r) {
			while (l < arr.length - 1 && arr[l] < pivot) {
				++l;
			}

			while (r > 0 && pivot < arr[r]) {
				--r;
			}

			if (l <= r) {
				swap(arr, l++, r--);
			}
		}

		arr[left] = arr[r];
		arr[r] = pivot;

		return r;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}