package org.example;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_11003 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Deque<Node> deque = new ArrayDeque<>();

		for (int i = 0; i < N; ++i) {
			int value = Integer.parseInt(st.nextToken());

			while (!deque.isEmpty() && deque.getLast().getValue() > value) {
				deque.removeLast();
			}

			deque.addLast(new Node(value, i));

			if (deque.getFirst().getIndex() <= i - L) {
				deque.removeFirst();
			}

			bw.write(deque.getFirst().getValue() + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static class Node {
		private final int value;
		private final int index;

		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}

		public int getValue() {
			return value;
		}

		public int getIndex() {
			return index;
		}
	}
}