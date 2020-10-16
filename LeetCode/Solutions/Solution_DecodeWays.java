import java.util.*;

public class Solution_DecodeWays {

	public static int DFS(int[] dp, String s, int idx) {
		if (idx < 0)
			return 1;

		if (dp[idx] != -1)
			return dp[idx];

		dp[idx] = 0;

		if (s.charAt(idx) != '0')
			dp[idx] += DFS(dp, s, idx - 1);

		if (idx > 0 && s.charAt(idx - 1) != '0') {
			int num = Integer.parseInt(s.substring(idx - 1, idx + 1));

			if (1 <= num && num <= 26)
				dp[idx] += DFS(dp, s, idx - 2);
		}

		return dp[idx];
	}

	public static int numDecodings(String s) {
		int len = s.length();
		int[] dp = new int[len];

		if (len == 0)
			return 0;

		Arrays.fill(dp, -1);

		return DFS(dp, s, len - 1);
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("12")); // 2
		System.out.println(numDecodings("226")); // 3
		System.out.println(numDecodings("0")); // 0
		System.out.println(numDecodings("1")); // 1
		System.out.println(numDecodings("111111111111111111111111111111111111111111111")); // 1836311903
	}
}
