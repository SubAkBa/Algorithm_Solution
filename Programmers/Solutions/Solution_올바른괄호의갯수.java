
public class Solution_올바른괄호의갯수 {
	static int[][] comb = new int[29][29];

	public static int Combination(int n, int k) {
		if (n == k || k == 0)
			return comb[n][k] = 1;

		if (comb[n][k] != 0)
			return comb[n][k];

		return comb[n][k] = Combination(n - 1, k) + Combination(n - 1, k - 1);
	}

	public static int solution(int n) {
		return Combination(2 * n, n) - Combination(2 * n, n + 1);
	}

	public static void main(String[] args) {
		System.out.println(solution(2)); // 2
		System.out.println(solution(3)); // 5
	}
}
