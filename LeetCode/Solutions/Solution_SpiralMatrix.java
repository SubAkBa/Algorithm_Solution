import java.util.*;

public class Solution_SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> answer = new ArrayList<>();
		int m = matrix.length;

		if (m == 0)
			return answer;

		int n = matrix[0].length;

		if (n == 0)
			return answer;

		int top = 0, bottom = m - 1, left = 0, right = n - 1;
		int round = m * n;

		while (round > 0) {
			for (int i = left; i <= right && round > 0; ++i, --round)
				answer.add(matrix[top][i]);

			++top;

			for (int i = top; i <= bottom && round > 0; ++i, --round)
				answer.add(matrix[i][right]);

			--right;

			for (int i = right; i >= left && round > 0; --i, --round)
				answer.add(matrix[bottom][i]);

			--bottom;

			for (int i = bottom; i >= top && round > 0; --i, --round)
				answer.add(matrix[i][left]);

			++left;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } })); // [1,2,3,6,9,8,7,4,5]
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } })); // [1,2,3,4,8,12,11,10,9,5,6,7]
		System.out.println(spiralOrder(new int[][] { { 1 } })); // [1]
	}
}
