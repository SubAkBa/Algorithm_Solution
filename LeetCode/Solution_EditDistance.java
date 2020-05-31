
public class Solution_EditDistance {

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length(), len2 = word2.length();
		int[][] cost = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len2; i++)
			cost[0][i] = i;
		for (int i = 1; i <= len1; i++)
			cost[i][0] = i;

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (word1.charAt(i - 1) != word2.charAt(j - 1))
					cost[i][j] = Math.min(cost[i - 1][j - 1], Math.min(cost[i - 1][j], cost[i][j - 1])) + 1;
				else
					cost[i][j] = cost[i - 1][j - 1];
			}
		}

		return cost[len1][len2];
	}

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
		System.out.println(minDistance("intention", "execution"));
	}

}
