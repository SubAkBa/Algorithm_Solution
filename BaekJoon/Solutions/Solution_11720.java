package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String numberStr = br.readLine();
		int total = 0;

		for (int i = 0; i < N; ++i) {
			total += numberStr.charAt(i) - '0';
		}

		bw.write(String.valueOf(total));
		bw.close();
		br.close();
	}
}

