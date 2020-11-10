import java.util.*;
import java.io.*;

public class Solution_1949 {

	public static void DFS(int N, List<Integer>[] adj, int[] counts, int[][] dp, int from, int prev) {
		for (int to : adj[from]) {
			if (to == prev)
				continue;

			DFS(N, adj, counts, dp, to, from);
			dp[from][0] += Math.max(dp[to][0], dp[to][1]);
			dp[from][1] += dp[to][0];
		}

		dp[from][1] += counts[from];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] counts = new int[N + 1];
		List<Integer>[] adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i) {
			adj[i] = new ArrayList<>();
			counts[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}

		int[][] dp = new int[N + 1][2];
		DFS(N, adj, counts, dp, 1, 0);

		bw.write(Math.max(dp[1][0], dp[1][1]) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
