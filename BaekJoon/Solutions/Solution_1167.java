import java.util.*;
import java.io.*;

public class Solution_1167 {
	static int end_point;
	static long max_weight;

	public static void DFS(int V, List<Node>[] adj, boolean[] visited, int node, long curWeight) {
		visited[node] = true;

		if (curWeight > max_weight) {
			max_weight = curWeight;
			end_point = node;
		}

		for (Node to : adj[node]) {
			if (visited[to.idx])
				continue;

			DFS(V, adj, visited, to.idx, curWeight + to.weight);
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
		int V = Integer.parseInt(br.readLine());
		List<Node>[] adj = new ArrayList[V + 1];
		max_weight = 0;
		end_point = 0;

		for (int i = 0; i <= V; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 1; i <= V; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int fromNum = Integer.parseInt(st.nextToken());

			while (true) {
				int toNum = Integer.parseInt(st.nextToken());

				if (toNum == -1)
					break;

				int weight = Integer.parseInt(st.nextToken());

				adj[fromNum].add(new Node(toNum, weight));
			}
		}

		boolean[] visited = new boolean[V + 1];
		DFS(V, adj, visited, 1, 0);

		max_weight = 0;
		Arrays.fill(visited, false);
		DFS(V, adj, visited, end_point, 0);

		bw.write(max_weight + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
