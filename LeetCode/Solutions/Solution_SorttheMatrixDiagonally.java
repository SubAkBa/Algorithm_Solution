import java.util.*;

public class Solution_SorttheMatrixDiagonally {

	public static void ArrangeMatrix(int[][] mat, int m, int n, int r, int c) {
		int min = Math.min(m - r, n - c);

		if (min <= 0)
			return;

		int[] list = new int[min];

		for (int i = 0; i < min; i++)
			list[i] = mat[r + i][c + i];

		Arrays.sort(list);

		for (int i = 0; i < min; i++)
			mat[r + i][c + i] = list[i];
	}

	public static int[][] diagonalSort(int[][] mat) {
		int m = mat.length, n = mat[0].length;

		for (int r = 0, c = n - 1; c >= 0; c--)
			ArrangeMatrix(mat, m, n, r, c);

		for (int r = 1, c = 0; r < n; r++)
			ArrangeMatrix(mat, m, n, r, c);

		return mat;
	}

	public static void main(String[] args) {
		System.out.println(
				Arrays.deepToString(diagonalSort(new int[][] { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } })));
		System.out.println(Arrays.deepToString(diagonalSort(new int[][] { { 37, 98, 82, 45, 42 } })));
	}
}
