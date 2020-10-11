import java.util.*;

public class Solution_OutofBoundaryPaths {
	static int[] d = new int[] { -1, 0, 1, 0, -1 };
	static int MOD = 1000000007;
	static int[][][] memo;

	public static boolean isBoundary(int row, int col, int x, int y) {
		if (!(0 <= x && x < row && 0 <= y && y < col))
			return true;

		return false;
	}

	public static int DFS(int row, int col, int N, int x, int y) {
		if (isBoundary(row, col, x, y))
			return 1;

		if (N == 0)
			return 0;

		if (memo[x][y][N] != -1)
			return memo[x][y][N];

		memo[x][y][N] = 0;
		for (int i = 0; i < 4; ++i)
			memo[x][y][N] = (memo[x][y][N] + DFS(row, col, N - 1, x + d[i], y + d[i + 1])) % MOD;

		return memo[x][y][N] % MOD;
	}

	public static int findPaths(int m, int n, int N, int i, int j) {
		memo = new int[m][n][N + 1];

		for (int p = 0; p < m; ++p) {
			for (int q = 0; q < n; ++q)
				Arrays.fill(memo[p][q], -1);
		}

		return DFS(m, n, N, i, j);
	}

	public static void main(String[] args) {
		System.out.println(findPaths(2, 2, 2, 0, 0)); // 6
		System.out.println(findPaths(1, 3, 3, 0, 1)); // 12
		System.out.println(findPaths(8, 7, 16, 1, 5)); // 102984580
		System.out.println(findPaths(8, 50, 23, 5, 26)); // 914783380 (561592063x)
	}
}
