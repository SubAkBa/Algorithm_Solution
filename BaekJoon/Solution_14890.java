import java.util.*;
import java.io.*;

public class Solution_14890 {

	public static boolean isPossible(int[] map, int N, int L) {
		int lowcount = 1;

		for (int i = 1; i < N; i++) {
			if (map[i - 1] == map[i])
				lowcount++;
			else if (map[i - 1] - map[i] == -1) {

				if (lowcount < L)
					return false;

				lowcount = 1;
			} else if (map[i - 1] - map[i] == 1) {
				int highcount = 1;

				while (i < N - 1 && map[i] == map[i + 1] && highcount < L) {
					highcount++;
					i++;
				}

				if (highcount < L)
					return false;

				lowcount = 0;
			} else
				return false;
		}

		return true;
	}

	public static int CrossPath(int[][] map, int N, int L) {
		int count = 0;

		for (int i = 0; i < N; i++) {
			if (isPossible(map[i], N, L))
				count++;
		}

		int[] temparr = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				temparr[j] = map[j][i];

			if (isPossible(temparr, N, L))
				count++;
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		bw.write(CrossPath(map, N, L) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
