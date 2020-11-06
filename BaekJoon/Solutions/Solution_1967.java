import java.util.*;
import java.io.*;

public class Solution_1967 {
	static int end_point, max_weight;

	public static void DFS(int n, List<Node>[] adj, int[] dist, int node, int curWeight) {
		dist[node] = curWeight;

		if (dist[node] > max_weight) {
			max_weight = dist[node];
			end_point = node;
		}

		for (Node to : adj[node]) {
			if (dist[to.idx] == 0)
				DFS(n, adj, dist, to.idx, curWeight + to.weight);
		}
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
		int n = Integer.parseInt(br.readLine());
		List<Node>[] adj = new ArrayList[n + 1];

		for (int i = 0; i <= n; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 1; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adj[from].add(new Node(to, weight));
			adj[to].add(new Node(from, weight));
		}

		DFS(n, adj, new int[n + 1], 1, 0);

		DFS(n, adj, new int[n + 1], end_point, 0);

		bw.write(max_weight + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
