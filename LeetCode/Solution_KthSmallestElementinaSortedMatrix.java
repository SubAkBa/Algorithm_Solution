import java.util.*;

public class Solution_KthSmallestElementinaSortedMatrix {

//	public static int kthSmallest(int[][] matrix, int k) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		int row = matrix.length, col = matrix[0].length;
//
//		for (int i = 0; i < row; ++i) {
//			for (int j = 0; j < col; ++j)
//				pq.offer(matrix[i][j]);
//		}
//
//		while ((--k) > 0)
//			pq.poll();
//
//		return pq.poll();
//	}

	public static int Lower_Bounds(int[] arr, int col, int value) {
		int left = 0, right = col - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (value <= arr[mid])
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static int Upper_Bounds(int[] arr, int col, int value) {
		int left = 0, right = col - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (value < arr[mid])
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static int kthSmallest(int[][] matrix, int k) {
		int row = matrix.length, col = matrix[0].length;
		int left = matrix[0][0], right = matrix[row - 1][col - 1];

		while (left < right) {
			int mid = left + (right - left) / 2;

			int count = 0;
			for (int i = 0; i < row; ++i) {
				int lower_idx = Lower_Bounds(matrix[i], col, mid);
				int upper_idx = Upper_Bounds(matrix[i], col, mid);

				if (upper_idx == lower_idx) {
					if (matrix[i][lower_idx] <= mid)
						++count;

					count += lower_idx;
				} else
					count += upper_idx;
			}

			if (k <= count)
				right = mid;
			else
				left = mid + 1;
		}

		return right;
	}

	public static void main(String[] args) {
		System.out.println(kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8)); // 13
		System.out.println(kthSmallest(new int[][] { { 5, 6, 9, 14, 17, 17, 19 }, { 8, 10, 14, 15, 21, 24, 28 },
				{ 8, 10, 16, 21, 21, 26, 33 }, { 13, 17, 17, 23, 26, 27, 33 }, { 16, 22, 23, 27, 31, 31, 34 },
				{ 16, 26, 28, 30, 32, 32, 37 }, { 19, 31, 35, 35, 39, 44, 44 } }, 38)); // 31
		System.out.println(kthSmallest(new int[][] { { 1, 2 }, { 1, 3 } }, 3)); // 2
	}
}
