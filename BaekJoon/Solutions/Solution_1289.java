import java.util.*;
import java.io.*;

public class Solution_1289 {
	static int MOD = 1000000007;
	static long result;

	public static long DFS(int N, List<Node>[] adj, int from, int prev) {
		long temp = 1;

		for (Node to : adj[from]) {
			if (to.idx == prev)
				continue;

			long sum = DFS(N, adj, to.idx, from) * to.weight % MOD;
			result = (result + temp * sum) % MOD;
			temp = (temp + sum) % MOD;
		}

		return temp;
	}

	public static class Node {
		int idx, weight;

		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		List<Node>[] adj = new ArrayList[N + 1];
		result = 0;

		for (int i = 0; i <= N; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 1; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[a].add(new Node(b, w));
			adj[b].add(new Node(a, w));
		}

		DFS(N, adj, 1, 0);

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
