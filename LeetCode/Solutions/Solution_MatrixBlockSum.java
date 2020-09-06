import java.util.*;

public class Solution_MatrixBlockSum {

	public static int[][] matrixBlockSum(int[][] mat, int K) {
		int m = mat.length, n = mat[0].length;
		int[][] sum = new int[m][n];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == 0 && j == 0)
					sum[i][j] = mat[i][j];
				else if (i == 0)
					sum[i][j] = sum[i][j - 1] + mat[i][j];
				else if (j == 0)
					sum[i][j] = sum[i - 1][j] + mat[i][j];
				else
					sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + mat[i][j] - sum[i - 1][j - 1];
			}
		}

//		for (int i = 0; i < m; ++i)
//			System.out.println(Arrays.toString(mat[i]));
//		System.out.println();
//		for (int i = 0; i < m; ++i)
//			System.out.println(Arrays.toString(sum[i]));

		int[][] answer = new int[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				int br_r = (i + K >= m ? m - 1 : i + K);
				int br_c = (j + K >= n ? n - 1 : j + K);

				int tl_r = (i - K - 1 < 0 ? -1 : i - K - 1);
				int tl_c = (j - K - 1 < 0 ? -1 : j - K - 1);

				int row_sum = (tl_r == -1 ? 0 : sum[tl_r][br_c]);
				int col_sum = (tl_c == -1 ? 0 : sum[br_r][tl_c]);
				int dia_sum = (tl_r == -1 || tl_c == -1 ? 0 : sum[tl_r][tl_c]);

				answer[i][j] = sum[br_r][br_c] - row_sum - col_sum + dia_sum;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out
				.println(Arrays.deepToString(matrixBlockSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 1)));
		System.out
				.println(Arrays.deepToString(matrixBlockSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 2)));
	}
}
