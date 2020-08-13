
public class Solution_CountNegativeNumbersinaSortedMatrix {

	public static int countNegatives(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		int sum = 0;

		for (int i = 0; i < n; ++i) {
			if (grid[i][0] < 0) {
				sum += m;
				continue;
			}

			if (grid[i][m - 1] >= 0)
				continue;

			int left = 0, right = m - 1;

			while (left <= right) {
				int mid = (left + right) >> 1;

				if (grid[i][mid] < 0)
					right = mid - 1;
				else
					left = mid + 1;
			}

			sum += m - left;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(
				countNegatives(new int[][] { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } })); // 8
		System.out.println(countNegatives(new int[][] { { 3, 2 }, { 1, 0 } })); // 0
		System.out.println(countNegatives(new int[][] { { 1, -1 }, { -1, -1 } })); // 3
		System.out.println(countNegatives(new int[][] { { -1 } })); // 1
	}

}
