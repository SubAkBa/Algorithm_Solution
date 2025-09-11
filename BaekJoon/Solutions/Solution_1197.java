import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1197 {
	static int[] parent;
	static int[] size;

	public static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static int find(int node) {
		if (node == parent[node]) {
			return node;
		}

		return parent[node] = find(parent[node]);
	}

	public static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);

		if (aParent == bParent) {
			return;
		}

		if (size[aParent] < size[bParent]) {
			parent[aParent] = bParent;
		} else if (size[aParent] > size[bParent]) {
			parent[bParent] = aParent;
		} else {
			parent[bParent] = aParent;
			++size[aParent];
		}
	}

	public static int kruskal(int V, Edge[] edges) {
		Arrays.sort(edges);

		int total = 0, count = 0;
		for (Edge edge : edges) {
			if (find(edge.from) != find(edge.to)) {
				union(edge.from, edge.to);
				++count;
				total += edge.cost;
			}

			if (count == V - 1) {
				break;
			}
		}

		return total;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[E];
		parent = new int[V + 1];
		size = new int[V + 1];

		for (int i = 1; i <= V; ++i) {
			parent[i] = i;
			size[i] = 1;
		}

		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(A, B, C);
		}

		System.out.println(kruskal(V, edges));
	}
}
