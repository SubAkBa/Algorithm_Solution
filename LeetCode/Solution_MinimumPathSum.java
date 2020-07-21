
public class Solution_MinimumPathSum {

	public static int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[] dp = new int[n];

		for (int x = 0; x < m; ++x) {
			for (int y = 0; y < n; ++y) {
				if (x == 0 && y == 0)
					dp[y] = grid[x][y];
				else if (x == 0)
					dp[y] = dp[y - 1] + grid[x][y];
				else if (y == 0)
					dp[y] += grid[x][y];
				else
					dp[y] = Math.min(dp[y], dp[y - 1]) + grid[x][y];
			}
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
	}

}
