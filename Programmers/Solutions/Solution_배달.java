import java.util.*;

public class Solution_배달 {
	final static int INF = 987654321;

	public static int Delivery(int[][] adj, int start, int N, int K) {
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		Arrays.fill(dist, INF);

		visited[start] = true;
		dist[start] = 0;
		pq.offer(new Edge(start, dist[start]));

		while (!pq.isEmpty()) {
			Edge from = pq.poll();

			for (int to = 1; to <= N; ++to) {
				if (adj[from.idx][to] == 0 || dist[to] <= dist[from.idx] + adj[from.idx][to])
					continue;

				visited[to] = true;
				dist[to] = dist[from.idx] + adj[from.idx][to];
				pq.offer(new Edge(to, dist[to]));
			}
		}

		int count = 0;
		for (int i = 1; i <= N; ++i) {
			if (dist[i] <= K)
				++count;
		}

		return count;
	}

	public static int solution(int N, int[][] road, int K) {
		int[][] adj = new int[N + 1][N + 1];

		int road_len = road.length;

		for (int i = 0; i < road_len; ++i) {
			if (adj[road[i][0]][road[i][1]] == 0 || adj[road[i][0]][road[i][1]] > road[i][2]) {
				adj[road[i][0]][road[i][1]] = road[i][2];
				adj[road[i][1]][road[i][0]] = road[i][2];
			}
		}

		return Delivery(adj, 1, N, K);
	}

	public static class Edge implements Comparable<Edge> {
		int idx, cost;

		public Edge(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(5,
				new int[][] { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } }, 3)); // 4
		System.out.println(solution(6, new int[][] { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 },
				{ 3, 5, 3 }, { 5, 6, 1 } }, 4)); // 4
	}
}
