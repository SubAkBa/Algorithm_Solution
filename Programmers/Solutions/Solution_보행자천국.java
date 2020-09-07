
public class Solution_보행자천국 {
	static int MOD = 20170805;
//	static int[] d = new int[] { 0, 1, 0 };
//
//	public static int DFS(int m, int n, int[][] cityMap, int x, int y, int dir, boolean[][] visited) {
//		if (x == m - 1 && y == n - 1)
//			return 1;
//
//		if (!(0 <= x && x < m && 0 <= y && y < n))
//			return 0;
//
//		if (visited[x][y])
//			return 0;
//
//		if (cityMap[x][y] == 1)
//			return 0;
//
//		visited[x][y] = true;
//		int count = 0;
//
//		if (cityMap[x][y] == 2)
//			count += DFS(m, n, cityMap, x + d[dir], y + d[dir + 1], dir, visited) % MOD;
//		else if (cityMap[x][y] == 0) {
//			for (int i = 0; i < 2; ++i) {
//				int nx = x + d[i];
//				int ny = y + d[i + 1];
//
//				count += DFS(m, n, cityMap, nx, ny, i, visited) % MOD;
//			}
//		}
//
//		visited[x][y] = false;
//
//		return count;
//	}

	public static int solution(int m, int n, int[][] cityMap) {
		int[][][] counts = new int[2][m + 1][n + 1];

		counts[0][1][1] = counts[1][1][1] = 1;

		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				switch (cityMap[i - 1][j - 1]) {
				case 0:
					counts[0][i][j] += (counts[0][i - 1][j] % MOD + counts[1][i][j - 1] % MOD) % MOD;
					counts[1][i][j] += (counts[0][i - 1][j] % MOD + counts[1][i][j - 1] % MOD) % MOD;
					break;
				case 2:
					counts[0][i][j] = counts[0][i - 1][j] % MOD;
					counts[1][i][j] = counts[1][i][j - 1] % MOD;
					break;
				}
			}
		}

		return (counts[0][m - 1][n] + counts[1][m][n - 1]) % MOD;
//		return DFS(m, n, cityMap, 0, 0, -1, new boolean[m][n]);
	}

	public static void main(String[] args) {
		System.out.println(solution(3, 3, new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } })); // 6
		System.out.println(
				solution(3, 6, new int[][] { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } })); // 2
	}
}
