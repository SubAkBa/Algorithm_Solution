import java.util.*;
import java.io.*;

public class Solution_1647 {
	static int[] parent, rank;
	static int N;
	static PriorityQueue<Edge> edgelist;

	public static void Initialize() {
		for (int i = 1; i <= N; i++)
			parent[i] = i;
	}

	public static void Swap(int n1, int n2) {
		int temp = n1;
		n1 = n2;
		n2 = temp;
	}

	public static int Find(int u) {
		if (parent[u] == u)
			return u;

		return parent[u] = Find(parent[u]);
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

	public static class Edge implements Comparable<Edge> {
		int x, y, cost;

		public Edge(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}

	public static int Kruskal() {
		int mcost = 0;
		int count = 0;

		while (count < N - 2) {
			Edge edge = edgelist.poll();


			if (Find(edge.x) != Find(edge.y)) {
				mcost += edge.cost;
				count++;
				Union(edge.x, edge.y);
			}
		}

		return mcost;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		rank = new int[N + 1];
		edgelist = new PriorityQueue<>();

		Initialize();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edgelist.offer(new Edge(from, to, cost));
		}

		bw.write(Kruskal() + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
