import java.io.*;
import java.util.*;

public class Solution_2533 {

	public static int Min(int a, int b) {
		return a < b ? a : b;
	}

	public static void DFS(int N, List<Integer>[] adj, int[][] dp, boolean[] visited, int from) {
		visited[from] = true;

		dp[from][1] = 1;

		for (int to : adj[from]) {
			if (visited[to])
				continue;

			DFS(N, adj, dp, visited, to);

			dp[from][0] += dp[to][1];
			dp[from][1] += Min(dp[to][0], dp[to][1]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		List<Integer>[] adj = new ArrayList[N + 1];

		for (int i = 0; i <= N; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 1; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		int[][] dp = new int[N + 1][2];

		DFS(N, adj, dp, new boolean[N + 1], 1);

		bw.write(Min(dp[1][1], dp[1][0]) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
