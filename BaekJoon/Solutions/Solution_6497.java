import java.util.*;
import java.io.*;

public class Solution_6497 {
	static int[] parent, rank;
	static PriorityQueue<Edge> edgelist;

	public static void Swap(int n1, int n2) {
		int temp = n1;
		n1 = n2;
		n2 = temp;
	}

	public static void Initialize(int m) {
		for (int i = 0; i < m; i++)
			parent[i] = i;
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
			rank[uR]++;
	}

	public static int Kruskal(int n, int total) {
		int cost = 0, count = 0;

		while (!edgelist.isEmpty()) {
			Edge edge = edgelist.poll();
			
			if(count == n - 1)
				break;

			if (Find(edge.from) != Find(edge.to)) {
				Union(edge.from, edge.to);
				cost += edge.cost;
				count++;
			}
		}

		return total - cost;
	}

	public static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(m == 0 && n == 0)
				break;

			parent = new int[m];
			rank = new int[m];
			edgelist = new PriorityQueue<>();

			Initialize(m);
			
			int total = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				edgelist.offer(new Edge(from, to, cost));
				total += cost;
			}

			bw.write(Kruskal(n, total) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
