import java.util.*;

public class Solution_FindLongestAwesomeSubstring {

	public static int longestAwesome(String s) {
		int len = s.length();
		int[] min_idx = new int[1024];

		Arrays.fill(min_idx, len);

		min_idx[0] = -1;

		int mask = 0, answer = 0;
		for (int i = 0; i < len; ++i) {
			mask ^= (1 << (s.charAt(i) - '0'));

			answer = Math.max(answer, i - min_idx[mask]);
			for (int j = 0; j < 10; ++j)
				answer = Math.max(answer, i - min_idx[mask ^ (1 << j)]);

			min_idx[mask] = Math.min(min_idx[mask], i);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(longestAwesome("3242415")); // 5
//		System.out.println(longestAwesome("213123")); // 6
//		System.out.println(longestAwesome("00")); // 2
//		System.out.println(longestAwesome("04857694736375838972847589109823048092357092735")); // 27
	}
}
