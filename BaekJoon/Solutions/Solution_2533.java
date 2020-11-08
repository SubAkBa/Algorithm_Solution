import java.io.*;
import java.util.*;

public class Solution_2533 {

	public static void DFS(int N, List<Integer>[] adj, List<Integer>[] adj2, boolean[] visited, int from) {
		visited[from] = true;

		for (int to : adj[from]) {
			if (visited[to])
				continue;

			adj2[from].add(to);
			DFS(N, adj, adj2, visited, to);
		}
	}

	public static int TreeDP(int N, List<Integer>[] adj2, int[][] dp, int from, int early) {
		if (dp[from][early] != -1)
			return dp[from][early];

		int result = 0;
		if (early == 1) {
			++result;

			for (int to : adj2[from])
				result += Math.min(TreeDP(N, adj2, dp, to, 1), TreeDP(N, adj2, dp, to, 0));
		} else {
			for (int to : adj2[from])
				result += TreeDP(N, adj2, dp, to, 1);
		}

		return dp[from][early] = result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		List<Integer>[] adj = new ArrayList[N + 1];
		List<Integer>[] adj2 = new ArrayList[N + 1];

		for (int i = 0; i <= N; ++i) {
			adj[i] = new ArrayList<>();
			adj2[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		DFS(N, adj, adj2, new boolean[N + 1], 1);

		int[][] dp = new int[N + 1][2];

		for (int i = 0; i <= N; ++i)
			Arrays.fill(dp[i], -1);

		bw.write(Math.min(TreeDP(N, adj2, dp, 1, 0), TreeDP(N, adj2, dp, 1, 1)) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
