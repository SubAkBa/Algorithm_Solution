package org.example;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_17298 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] seq = new int[N];

		for (int i = 0; i < N; ++i) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		int[] rightBiggerNum = new int[N];

		for (int i = 0; i < N; ++i) {
			while (!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
				rightBiggerNum[stack.pop()] = seq[i];
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			rightBiggerNum[stack.pop()] = -1;
		}

		for (int i = 0; i < N; ++i) {
			bw.write(rightBiggerNum[i] + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
