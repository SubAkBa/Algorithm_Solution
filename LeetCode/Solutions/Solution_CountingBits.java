import java.util.*;

public class Solution_CountingBits {

	public static int[] countBits(int num) {
		int[] dp = new int[num + 1];

		for (int i = 1; i <= num; ++i)
//			dp[i] = dp[i & (i - 1)] + 1;
			dp[i] = dp[i >> 1] + (i & 1);

		return dp;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(2))); // [0,1,1]
		System.out.println(Arrays.toString(countBits(5))); // [0,1,1,2,1,2]
	}
}
