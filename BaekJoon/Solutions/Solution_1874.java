package org.example;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1874 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];

		for (int i = 0; i < n; ++i) {
			input[i] = Integer.parseInt(br.readLine());
		}

		int num = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; ++i) {
			while (stack.isEmpty() || num < input[i]) {
				stack.push(++num);
				sb.append("+\n");
			}

			if (stack.peek() > input[i]) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}

			stack.pop();
			sb.append("-\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
