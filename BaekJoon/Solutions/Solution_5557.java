import java.util.*;
import java.io.*;

public class Solution_5557 {
	static int MAX = 20;

	public static long DFS(int[] nums, int sum, int idx, int N, long[][] dp) {
		if (idx == N - 1)
			return (sum == nums[N - 1]) ? 1L : 0L;

		if (!(0 <= sum && sum <= MAX))
			return 0L;

		if (dp[idx][sum] != 0)
			return dp[idx][sum];

		return dp[idx][sum] = DFS(nums, sum + nums[idx], idx + 1, N, dp) + DFS(nums, sum - nums[idx], idx + 1, N, dp);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] nums = new int[N];
		long[][] dp = new long[N][MAX + 1];

		for (int i = 0; i < N; ++i)
			nums[i] = Integer.parseInt(st.nextToken());

		bw.write(DFS(nums, nums[0], 1, N, dp) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
