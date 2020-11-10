import java.util.*;
import java.io.*;

public class Solution_14267 {

	public static void DFS(int n, List<Integer>[] adj, int[] dp, int from, int prev) {
		dp[from] += dp[prev];

		for (int to : adj[from]) {
			if (to == prev)
				continue;

			DFS(n, adj, dp, to, from);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer>[] adj = new ArrayList[n + 1];

		for (int i = 1; i <= n; ++i)
			adj[i] = new ArrayList<>();

		st.nextToken();
		for (int i = 2; i <= n; ++i)
			adj[Integer.parseInt(st.nextToken())].add(i);

		int[] dp = new int[n + 1];
		while ((--m) >= 0) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			dp[i] += w;
		}

		DFS(n, adj, dp, 1, 0);

		for (int i = 1; i <= n; ++i)
			bw.write(dp[i] + " ");

		bw.flush();
		bw.close();
		br.close();
	}
}
