
public class Solution_CountSquareSubmatriceswithAllOnes {

	public static int countSquares(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int count = 0;

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if ((i == 0 || j == 0) && matrix[i][j] == 1)
					++count;
				else if (matrix[i][j] != 0) {
					matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
					count += matrix[i][j];
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(countSquares(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } })); // 15
		System.out.println(countSquares(new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } })); // 7
		System.out.println(countSquares(new int[][] { { 1 } })); // 1
		System.out.println(countSquares(new int[][] { { 0 } })); // 0
	}
}
