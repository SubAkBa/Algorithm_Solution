import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1854 {

	public static class Edge implements Comparable<Edge> {
		int node, weight;

		public Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void dijkstra(int K, List<Edge>[] adjList, PriorityQueue<Integer>[] distQueue) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		pq.offer(new Edge(1, 0));
		distQueue[1].add(0);

		while (!pq.isEmpty()) {
			Edge current = pq.poll();

			if (distQueue[current.node].size() == K && current.weight > distQueue[current.node].peek()) {
				continue;
			}

			for (Edge next : adjList[current.node]) {
				if (distQueue[next.node].size() < K) {
					distQueue[next.node].add(next.weight + current.weight);
					pq.offer(new Edge(next.node, next.weight + current.weight));
				} else if (distQueue[next.node].peek() > next.weight + current.weight) {
					distQueue[next.node].poll();
					distQueue[next.node].add(next.weight + current.weight);
					pq.offer(new Edge(next.node, next.weight + current.weight));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		List<Edge>[] adjList = new ArrayList[n + 1];
		PriorityQueue<Integer>[] distQueue = new PriorityQueue[n + 1];

		for (int i = 1; i <= n; ++i) {
			adjList[i] = new ArrayList<>();
			distQueue[i] = new PriorityQueue<>(Comparator.reverseOrder());
		}

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList[a].add(new Edge(b, c));
		}

		dijkstra(k, adjList, distQueue);

		for (int i = 1; i <= n; ++i) {
			if (distQueue[i].size() == k) {
				System.out.println(distQueue[i].peek());
			} else {
				System.out.println(-1);
			}
		}
	}
}
