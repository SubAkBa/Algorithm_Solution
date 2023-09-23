package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_1517 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] temp;
	static long result;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		result = 0;
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		temp = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(arr, 0, N - 1);

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (left + 1 > right) {
			return;
		}

		int mid = left + (right - left) / 2;

		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);

		for (int i = left; i <= right; ++i) {
			temp[i] = arr[i];
		}

		int idx = left;
		int l = left;
		int r = mid + 1;

		while (l <= mid && r <= right) {
			if (temp[l] > temp[r]) {
				result += r - idx;
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
