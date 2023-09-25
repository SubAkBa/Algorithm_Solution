package org.example;

import java.io.*;

public class Solution_2023 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] types = new int[] {1, 2, 3, 5, 7, 9};

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		for (int type : types) {
			DFS(type, 1, N);
		}

		br.close();
	}

	public static void DFS(int num, int pos, int N) {
		if (!isPrime(num)) {
			return;
		}

		if (pos == N) {
			System.out.println(num);
			return;
		}

		for (int type : types) {
			DFS(num * 10 + type, pos + 1, N);
		}
	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}

		if (n == 2) {
			return true;
		}

		if (n % 2 == 0) {
			return false;
		}

		int sqrtN = (int)Math.sqrt(n);

		for (int div = 3; div <= sqrtN; div += 2) {
			if (n % div == 0) {
				return false;
			}
		}

		return true;
	}
}
