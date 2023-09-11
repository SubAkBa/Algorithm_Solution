package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1940 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 0, right = N - 1;
		int count = 0;
		while (left < right) {
			int sum = arr[left] + arr[right];

			if (sum == M) {
				++count;
				--right;
			} else if (sum > M) {
				--right;
			} else {
				++left;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
