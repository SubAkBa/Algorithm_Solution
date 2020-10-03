
public class Solution_MinimumFallingPathSum {

	public static int minFallingPathSum(int[][] A) {
		int len = A.length, answer = Integer.MAX_VALUE;

		for (int i = 1; i < len; ++i) {
			for (int j = 0; j < len; ++j) {
				if (j == 0)
					A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
				else if (j == len - 1)
					A[i][j] += Math.min(A[i - 1][j], A[i - 1][j - 1]);
				else
					A[i][j] += Math.min(Math.min(A[i - 1][j], A[i - 1][j - 1]), A[i - 1][j + 1]);
			}
		}

		for (int i = 0; i < len; ++i)
			answer = Math.min(answer, A[len - 1][i]);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(minFallingPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } })); // 12
	}
}
