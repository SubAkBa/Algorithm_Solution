package org.example;

import java.io.*;
import java.util.Arrays;

public class Solution_1377 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		Element[] elementList = new Element[N];
		for (int i = 0; i < N; ++i) {
			elementList[i] = new Element(i, Integer.parseInt(br.readLine()));
		}

		Arrays.sort(elementList);

		int maxMoveCount = 0;

		for (int i = 0; i < N; ++i) {
			maxMoveCount = Math.max(maxMoveCount, elementList[i].idx - i);
		}

		bw.write(String.valueOf(maxMoveCount + 1));
		bw.flush();
		bw.close();
		br.close();
	}

	public static class Element implements Comparable<Element> {
		private int idx;
		private int value;

		public Element(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}

		@Override
		public int compareTo(Element o) {
			return this.value - o.value;
		}
	}
}
