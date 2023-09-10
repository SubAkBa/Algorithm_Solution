package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_10986 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long[] arr = new long[N + 1];
		long[] prefixSum = new long[N + 1];
		long[] remainderArr = new long[M];
		for (int i = 1; i <= N; ++i) {
			arr[i] = Long.parseLong(st.nextToken());
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		long count = 0;
		for (int i = 1; i <= N; ++i) {
			int remainder = (int) (prefixSum[i] % M);

			if (remainder == 0) {
				++count;
			}
			++remainderArr[remainder];
		}

		for (int i = 0; i < M; ++i) {
			count += remainderArr[i] * (remainderArr[i] - 1) / 2L;
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
