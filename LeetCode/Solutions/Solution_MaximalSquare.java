
public class Solution_MaximalSquare {

	public static int maximalSquare(char[][] matrix) {
		int r = matrix.length;
		int len = 0;

		if (r == 0)
			return len;

		int c = matrix[0].length;
		int[][] dp = new int[r + 1][c + 1];

		for (int i = 1; i <= r; ++i) {
			for (int j = 1; j <= c; ++j) {
				if (matrix[i - 1][j - 1] == '0')
					continue;

				dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
				len = Math.max(len, dp[i][j]);
			}
		}

		return len * len;
	}

	public static void main(String[] args) {
		System.out.println(maximalSquare(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } })); // 4
		System.out.println(maximalSquare(new char[][] { { '1' } })); // 1
	}
}
