import java.util.*;
import java.io.*;

public class Solution_1922_2 {
	static int V, E;
	static Graph graph;
	static int[] parent, rank;

	public static void Swap(int n1, int n2) {
		int temp = n1;
		n1 = n2;
		n2 = temp;
	}

	public static void Union(int u, int v) {
		int uR = Find(u);
		int vR = Find(v);

		if (uR == vR)
			return;

		if (rank[uR] > rank[vR])
			Swap(uR, vR);

		parent[uR] = vR;

		if (rank[uR] == rank[vR])
			rank[vR]++;
	}

	public static int Find(int u) {
		if (u == parent[u])
			return u;

		return parent[u] = Find(parent[u]);
	}

	public static int NetworkMST() {
		int mincost = 0, idx = 0;

		Collections.sort(graph.edge);

		for (int i = 0; i < graph.edge.size(); i++) {
			Edge edge = graph.edge.get(i);

			if (Find(edge.from) != Find(edge.to)) {
				Union(edge.from, edge.to);
				mincost += edge.cost;
			}
		}

		return mincost;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		graph = new Graph(V);
		parent = new int[V + 1];
		rank = new int[V + 1];

		for (int i = 1; i <= V; i++)
			parent[i] = i;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.addEdge(from, to, cost);
		}

		bw.write(NetworkMST() + " ");

		bw.flush();
		bw.close();
		br.close();
	}

	public static class Graph {
		List<Edge> edge;

		public Graph(int V) {
			edge = new ArrayList<>();
		}

		public void addEdge(int from, int to, int cost) {
			edge.add(new Edge(from, to, cost));
		}
	}

	public static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}

	}
}
