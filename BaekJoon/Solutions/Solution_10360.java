import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_10360 {
	static int INF = 987654321;

	public static class Edge {
		int from, to, dist;

		public Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
	}

	public static void bellmanFord(int N, int M, Edge[] edges, int[] dist) {
		dist[0] = 0;

		for (int i = 0; i < 2 * N; ++i) {
			for (int j = 0; j < M; ++j) {
				Edge edge = edges[j];

				if (dist[edge.from] == Integer.MIN_VALUE) {
					dist[edge.to] = Integer.MIN_VALUE;
				} else if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.dist) {
					dist[edge.to] = dist[edge.from] + edge.dist;

					if (i == N - 1) {
						dist[edge.to] = Integer.MIN_VALUE;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Edge[] edges = new Edge[M];
			int[] dist = new int[N];

			Arrays.fill(dist, INF);

			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());

				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(A, B, C);
			}

			bellmanFord(N, M, edges, dist);
			System.out.print("Case #" + t + ": ");
			if (dist[0] == Integer.MIN_VALUE) {
				System.out.println("possible");
			} else {
				System.out.println("not possible");
			}
		}
	}
}
