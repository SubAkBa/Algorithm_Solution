package org.example;

import java.io.*;

public class Solution_1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] scoreStr = br.readLine().split(" ");
		double sum = 0;

		int maxScore = 0;
		for (int i = 0; i < N; ++i) {
			int score = Integer.parseInt(scoreStr[i]);

			sum += score;
			maxScore = Math.max(maxScore, score);
		}

		bw.write(String.valueOf(sum * 100 / maxScore / N));
		bw.flush();
		bw.close();
		br.close();
	}
}
