
public class Solution_OnesandZeroes {

	public static int[] GetCount(String str) {
		int[] count = new int[2];

		for (char c : str.toCharArray())
			++count[c - '0'];

		return count;
	}

	public static int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];

		for (String str : strs) {
			int[] count = GetCount(str);

			for (int i = m; i >= count[0]; --i) {

				for (int j = n; j >= count[1]; --j) {
					if (dp[i][j] < dp[i - count[0]][j - count[1]] + 1)
						dp[i][j] = dp[i - count[0]][j - count[1]] + 1;
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		System.out.println(findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3)); // 4
		System.out.println(findMaxForm(new String[] { "10", "0", "1" }, 1, 1)); // 2
	}
}
