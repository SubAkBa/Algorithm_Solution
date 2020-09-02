import java.util.*;
import java.io.*;

public class Solution_14889 {
	static int[][] ability;
	static int N, answer = Integer.MAX_VALUE;

	public static void StartNLink(int num, int sidx, int lidx, int[] start_team, int[] link_team) {
		if (num == N) {
			int start = 0, link = 0;

			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					start += ability[start_team[i]][start_team[j]];
					link += ability[link_team[i]][link_team[j]];
				}
			}

			answer = Math.min(answer, Math.abs(start - link));
			return;
		}

		if (sidx < N / 2) {
			start_team[sidx] = num;
			StartNLink(num + 1, sidx + 1, lidx, start_team, link_team);
		}

		if (lidx < N / 2) {
			link_team[lidx] = num;
			StartNLink(num + 1, sidx, lidx + 1, start_team, link_team);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		ability = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				ability[i][j] = Integer.parseInt(st.nextToken());
		}

		StartNLink(0, 0, 0, new int[N / 2], new int[N / 2]);

		bw.write(answer + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
