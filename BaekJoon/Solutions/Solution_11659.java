package org.example;

import java.io.*;

public class Solution_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] inputNM = br.readLine().split(" ");
		int N = Integer.parseInt(inputNM[0]);
		int M = Integer.parseInt(inputNM[1]);

		String[] inputStr = br.readLine().split(" ");
		int[] inputArr = new int[N + 1];
		int[] prefixSumArr = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			inputArr[i] = Integer.parseInt(inputStr[i - 1]);
			prefixSumArr[i] = prefixSumArr[i - 1] + inputArr[i];
		}

		while ((--M) >= 0) {
			String[] prefix = br.readLine().split(" ");
			int i = Integer.parseInt(prefix[0]);
			int j = Integer.parseInt(prefix[1]);

			bw.write(prefixSumArr[j] - prefixSumArr[i - 1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
