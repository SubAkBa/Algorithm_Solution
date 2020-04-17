import java.util.*;

public class Solution_connectisland {
	static int[] parent, rank;

	public static void Init(int n) {
		for (int i = 0; i < n; i++)
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

		if (rank[uR] > rank[vR]) {
			int temp = uR;
			uR = vR;
			vR = temp;
		}

		parent[uR] = vR;

		if (rank[uR] == rank[vR])
			rank[vR]++;
	}

	public static int MST(PriorityQueue<Edge> pq, int n) {
		int total = 0, count = 0;

		while (!pq.isEmpty() && count < n - 1) {
			Edge cur = pq.poll();

			if (Find(cur.from) != Find(cur.to)) {
				Union(cur.from, cur.to);
				total += cur.cost;
				count++;
			}
		}

		return total;
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

	public static int solution(int n, int[][] costs) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		parent = new int[n];
		rank = new int[n];

		Init(n);

		for (int i = 0; i < costs.length; i++)
			pq.offer(new Edge(costs[i][0], costs[i][1], costs[i][2]));

		return MST(pq, n);
	}

	public static void main(String[] args) {
		System.out
				.println(solution(4, new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } }));
	}

}
