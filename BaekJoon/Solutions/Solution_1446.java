import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1446 {

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

	public static void dijkstra(List<Edge>[] adjList, int[] weights) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		weights[0] = 0;
		pq.offer(new Edge(0, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (cur.weight != weights[cur.node]) {
				continue;
			}

			for (Edge next : adjList[cur.node]) {
				if (weights[next.node] > weights[cur.node] + next.weight) {
					weights[next.node] = weights[cur.node] + next.weight;
					pq.offer(new Edge(next.node, weights[next.node]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int INF = 987654321;
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		List<Edge>[] adjList = new ArrayList[D + 2];
		int[] weights = new int[D + 2];

		for (int i = 0; i <= D; ++i) {
			adjList[i] = new ArrayList<>();
			adjList[i].add(new Edge(i + 1, 1));
			weights[i] = INF;
		}

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (b > D) {
				continue;
			}

			adjList[a].add(new Edge(b, c));
		}

		dijkstra(adjList, weights);

		System.out.println(weights[D]);
	}
}
