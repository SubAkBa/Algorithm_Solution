package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_11660 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];
		int[][] prefixSumArr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				prefixSumArr[i][j] = arr[i][j] + prefixSumArr[i - 1][j] + prefixSumArr[i][j - 1] - prefixSumArr[i - 1][j - 1];
			}
		}

		while ((--M) >= 0) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			bw.write(prefixSumArr[x2][y2] - prefixSumArr[x1 - 1][y2] - prefixSumArr[x2][y1 - 1] + prefixSumArr[x1 - 1][y1 - 1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
