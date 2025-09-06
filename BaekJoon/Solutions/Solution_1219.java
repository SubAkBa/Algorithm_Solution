import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1219 {
	public static class Edge {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	public static void bellmanFord(int N, int M, Edge[] edges, long[] dist, int[] money, int start) {
		dist[start] = money[start];

		for (int i = 0; i < 2 * N; ++i) {
			for (int j = 0; j < M; ++j) {
				Edge edge = edges[j];

				if (dist[edge.from] == Long.MIN_VALUE) {
					continue;
				} else if (dist[edge.from] == Long.MAX_VALUE) {
					dist[edge.to] = Long.MAX_VALUE;
				} else if (dist[edge.to] < dist[edge.from] + edge.cost + money[edge.to]) {
					dist[edge.to] = dist[edge.from] + edge.cost + money[edge.to];
					if (i >= N - 1) {
						dist[edge.to] = Long.MAX_VALUE;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[M];
		long[] dist = new long[N];
		int[] money = new int[N];

		Arrays.fill(dist, Long.MIN_VALUE);

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(a, b, -c);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			money[i] = Integer.parseInt(st.nextToken());
		}

		bellmanFord(N, M, edges, dist, money, start);

		if (dist[end] == Long.MAX_VALUE) {
			System.out.println("Gee");
		} else if (dist[end] == Long.MIN_VALUE) {
			System.out.println("gg");
		} else {
			System.out.println(dist[end]);
		}
	}
}
