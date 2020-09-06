
public class Solution_UniqueBinarySearchTrees {
	static int[][] comb = new int[39][39];

	public static int Combination(int[][] comb, int n, int k) {
		if (n == k || k == 0)
			return comb[n][k] = 1;

		if (comb[n][k] != 0)
			return comb[n][k];

		return comb[n][k] = Combination(comb, n - 1, k) + Combination(comb, n - 1, k - 1);
	}

	public static int numTrees(int n) {
		return Combination(comb, 2 * n, n) - Combination(comb, 2 * n, n + 1);
	}

	public static void main(String[] args) {
		System.out.println(numTrees(3)); // 5
		System.out.println(numTrees(4)); // 14
		System.out.println(numTrees(5)); // 42
		System.out.println(numTrees(6)); // 132
		System.out.println(numTrees(7)); // 429
	}
}
