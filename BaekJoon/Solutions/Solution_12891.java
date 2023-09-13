package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_12891 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		String dnaStr = br.readLine();

		st = new StringTokenizer(br.readLine());
		int[] minCount = new int[26];

		minCount['A' - 'A'] = Integer.parseInt(st.nextToken());
		minCount['C' - 'A'] = Integer.parseInt(st.nextToken());
		minCount['G' - 'A'] = Integer.parseInt(st.nextToken());
		minCount['T' - 'A'] = Integer.parseInt(st.nextToken());

		int[] count = new int[26];
		int answer = 0;

		for (int i = 0; i < P; ++i) {
			++count[dnaStr.charAt(i) - 'A'];
		}

		if (isMeetArray(minCount, count)) {
			++answer;
		}

		for (int i = P; i < S; ++i) {
			++count[dnaStr.charAt(i) - 'A'];
			--count[dnaStr.charAt(i - P) - 'A'];

			if (isMeetArray(minCount, count)) {
				++answer;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean isMeetArray(int[] minCount, int[] count) {
		for (int i = 0; i < 26; ++i) {
			if (minCount[i] == 0) {
				continue;
			}

			if (minCount[i] > count[i]) {
				return false;
			}
		}

		return true;
	}
}
