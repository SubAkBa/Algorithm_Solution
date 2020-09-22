import java.util.*;
import java.io.*;

public class Solution_16438 {
	static int day, week = 7;

	public static void MonkeySports(char[][] team, int left, int right, int day_idx) {
		if (left >= right || day_idx == 7)
			return;

		day = Math.max(day, day_idx);

		int mid = (left + right) / 2;

		for (int i = left; i <= mid; ++i)
			team[day_idx][i] = 'A';

		for (int i = mid + 1; i <= right; ++i)
			team[day_idx][i] = 'B';

		MonkeySports(team, left, mid, day_idx + 1);
		MonkeySports(team, mid + 1, right, day_idx + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char[][] team = new char[week][N];
		day = 0;

		MonkeySports(team, 0, N - 1, 0);

//		for (int i = 0; i < week; ++i)
//			System.out.println(Arrays.toString(team[i]));
//		System.out.println();

		for (int i = 0; i <= day; ++i) {
			for (int j = 0; j < N; ++j) {
				if (team[i][j] != 'A' && team[i][j] != 'B')
					team[i][j] = 'A';

				bw.write(team[i][j] + "");
			}

			bw.newLine();
		}

		while ((++day) < week) {
			for (int i = 0; i < N; ++i)
				bw.write((i % 2 == 0) ? 'A' : 'B');

			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
