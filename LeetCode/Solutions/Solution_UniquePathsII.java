public class Solution_UniquePathsII {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;

		if (m == 0)
			return 0;

		int n = obstacleGrid[0].length;

		if (n == 0)
			return 1;

		int[] dp = new int[n];

		dp[0] = (obstacleGrid[0][0] == 1 ? 0 : 1);

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (obstacleGrid[i][j] == 1)
					dp[j] = 0;
				else if (j == 0)
					continue;
				else
					dp[j] += dp[j - 1];
			}
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } })); // 2
		System.out.println(uniquePathsWithObstacles(new int[][] { { 1 } })); // 0
		System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 0 } })); // 1
		System.out.println(uniquePathsWithObstacles(new int[][] { { 1, 0 } })); // 0
		System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 1 } })); // 0
		System.out.println(uniquePathsWithObstacles(new int[][] { {} })); // 1
	}
}
