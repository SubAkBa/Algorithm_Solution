
public class Solution_Searcha2DMatrixII {

	public static int C_Lower_Bounds(int[][] matrix, int target, int r, int n) {
		int left = 0, right = n - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (target <= matrix[r][mid])
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static int R_Lower_Bounds(int[][] matrix, int target, int c, int m) {
		int left = 0, right = m - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (target <= matrix[mid][c])
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;

		if (m == 0)
			return false;

		int n = matrix[0].length;

		if (n == 0)
			return false;

		int lr = R_Lower_Bounds(matrix, target, 0, m);
		int rr = R_Lower_Bounds(matrix, target, n - 1, m);

		for (int i = rr; i <= lr; ++i) {
			int idx = C_Lower_Bounds(matrix, target, i, n);

			if (matrix[i][idx] == target)
				return true;
		}

		return false;
	}

//	public static boolean searchMatrix(int[][] matrix, int target) {
//		int m = matrix.length;
//
//		if (m == 0)
//			return false;
//
//		int n = matrix[0].length;
//
//		if (n == 0)
//			return false;
//
//		int r = 0, c = n - 1;
//
//		while (r < m && 0 <= c) {
//			if (matrix[r][c] == target)
//				return true;
//			else if (matrix[r][c] > target)
//				--c;
//			else
//				++r;
//		}
//
//		return false;
//	}

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 5)); // true
		System.out.println(searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 20)); // false
	}
}
