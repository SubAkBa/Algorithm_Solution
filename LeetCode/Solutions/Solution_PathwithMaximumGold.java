
public class Solution_PathwithMaximumGold {
	static int m, n;
	static int[] d = { -1, 0, 1, 0, -1 };

	public static int DFS(int[][] grid, int x, int y, int sum) {
		int max_gold = 0;

		if (!(0 <= x && x < m && 0 <= y && y < n))
			return 0;

		if (grid[x][y] == 0)
			return 0;

		int gold = grid[x][y];
		grid[x][y] = 0;

		for (int i = 0; i < 4; ++i)
			max_gold = Math.max(max_gold, DFS(grid, x + d[i], y + d[i + 1], sum + gold));

		grid[x][y] = gold;

		return max_gold + gold;
	}

	public static int getMaximumGold(int[][] grid) {
		m = grid.length;
		n = grid[0].length;

		int max_gold = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 0)
					continue;

				max_gold = Math.max(max_gold, DFS(grid, i, j, 0));
			}
		}

		return max_gold;
	}

	public static void main(String[] args) {
		System.out.println(getMaximumGold(new int[][] { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } })); // 24
		System.out.println(
				getMaximumGold(new int[][] { { 1, 0, 7 }, { 2, 0, 6 }, { 3, 4, 5 }, { 0, 3, 0 }, { 9, 0, 20 } })); // 28
		System.out.println(getMaximumGold(new int[][] { { 0, 0, 34, 0, 5, 0, 7, 0, 0, 0 },
				{ 0, 0, 0, 0, 21, 0, 0, 0, 0, 0 }, { 0, 18, 0, 0, 8, 0, 0, 0, 4, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 15, 0, 0, 0, 0, 22, 0, 0, 0, 21 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 7, 0, 0, 0, 0, 0, 0, 38, 0 } })); // 38
	}
}
