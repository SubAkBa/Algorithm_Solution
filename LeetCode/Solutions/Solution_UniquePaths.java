
public class Solution_UniquePaths {

	public static int uniquePaths(int m, int n) {
		int[] path = new int[m];

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (i == 0 || j == 0)
					path[i] = 1;
				else
					path[i] = path[i] + path[i - 1];
			}
		}

		return path[m - 1];
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 2));
		System.out.println(uniquePaths(7, 3));
	}

}
