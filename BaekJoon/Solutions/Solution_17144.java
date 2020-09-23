import java.util.*;
import java.io.*;

public class Solution_17144 {
	static int R, C;

	public static void Add_Dusts(List<int[]> dusts, int[][] map) {
		dusts.clear();

		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (map[i][j] > 4)
					dusts.add(new int[] { i, j, map[i][j] });
			}
		}
	}

	public static void Diffusion(List<int[]> dusts, int[][] map) {
		int[] d = new int[] { -1, 0, 1, 0, -1 };

		for (int[] dust : dusts) {
			int count = 0;
			int dust_value = dust[2] / 5;

			for (int i = 0; i < 4; ++i) {
				int nx = dust[0] + d[i];
				int ny = dust[1] + d[i + 1];

				if (!(0 <= nx && nx < R && 0 <= ny && ny < C))
					continue;

				if (map[nx][ny] == -1)
					continue;

				++count;
				map[nx][ny] += dust_value;
			}

			map[dust[0]][dust[1]] -= dust_value * count;
		}
	}

	public static void Upper_Circulate(int x, int[][] map) {
		for (int i = x - 1; i > 0; --i)
			map[i][0] = map[i - 1][0];

		for (int i = 0; i < C - 1; ++i)
			map[0][i] = map[0][i + 1];

		for (int i = 0; i < x; ++i)
			map[i][C - 1] = map[i + 1][C - 1];

		for (int i = C - 1; i > 1; --i)
			map[x][i] = map[x][i - 1];

		map[x][1] = 0;
	}

	public static void Lower_Circulate(int x, int[][] map) {
		for (int i = x + 1; i < R - 1; ++i)
			map[i][0] = map[i + 1][0];

		for (int i = 0; i < C - 1; ++i)
			map[R - 1][i] = map[R - 1][i + 1];

		for (int i = R - 1; i > x; --i)
			map[i][C - 1] = map[i - 1][C - 1];

		for (int i = C - 1; i > 1; --i)
			map[x][i] = map[x][i - 1];

		map[x][1] = 0;
	}

	public static void Circulation(int[][] air_cleaner, int[][] map) {
		Upper_Circulate(air_cleaner[0][0], map);
		Lower_Circulate(air_cleaner[1][0], map);
	}

	public static int GetTotalDust(int[][] map) {
		int total = 0;

		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j)
				total += map[i][j];
		}

		return total + 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] air_cleaner = new int[2][2];
		int[][] map = new int[R][C];
		int idx = 0;
		List<int[]> dusts = new ArrayList<>();

		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < C; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == -1)
					air_cleaner[idx++] = new int[] { i, j };
				else if (map[i][j] > 4)
					dusts.add(new int[] { i, j, map[i][j] });
			}
		}

		while ((--T) >= 0) {
			Diffusion(dusts, map);

			Circulation(air_cleaner, map);

			Add_Dusts(dusts, map);
		}

		bw.write(GetTotalDust(map) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}