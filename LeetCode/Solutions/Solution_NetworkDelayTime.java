import java.util.*;

public class Solution_NetworkDelayTime {

	public static void Dijkstra(List<Element>[] adj, int N, int K, int[] dist) {
		PriorityQueue<Element> pq = new PriorityQueue<>();

		dist[K] = 0;
		pq.offer(new Element(K, dist[K]));

		while (!pq.isEmpty()) {
			Element from = pq.poll();

			for (Element to : adj[from.idx]) {
				if (dist[to.idx] <= dist[from.idx] + to.cost)
					continue;

				dist[to.idx] = dist[from.idx] + to.cost;
				pq.offer(new Element(to.idx, dist[to.idx]));
			}
		}
	}

	public static int networkDelayTime(int[][] times, int N, int K) {
		if (N == 1)
                        return 0;
		
		List<Element>[] adj = new ArrayList[N + 1];
		int tcount = times.length, INF = 987654321;

		for (int i = 1; i <= N; ++i)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < tcount; ++i)
			adj[times[i][0]].add(new Element(times[i][1], times[i][2]));

		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);

		Dijkstra(adj, N, K, dist);

		int time = 0;
		for (int i = 1; i <= N; ++i) {
			if (dist[i] == INF) {
				time = -1;
				break;
			}

			time = Math.max(time, dist[i]);
		}

		return time;
	}

	public static class Element implements Comparable<Element> {
		int idx, cost;

		public Element(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Element o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) {
		System.out.println(networkDelayTime(new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, 4, 2));
	}
}
