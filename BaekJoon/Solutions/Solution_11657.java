import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_11657 {
	static int INF = 987654321;

	public static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static boolean bellmanFord(int N, int M, Edge[] edges, long[] weights) {
		weights[1] = 0;

		for (int n = 1; n < N; ++n) {
			for (int m = 1; m <= M; ++m) {
				Edge edge = edges[m];
				if (weights[edge.from] != INF && weights[edge.to] > weights[edge.from] + edge.weight) {
					weights[edge.to] = weights[edge.from] + edge.weight;
				}
			}
		}

		for (int m = 1; m <= M; ++m) {
			Edge edge = edges[m];
			if (weights[edge.from] != INF && weights[edge.to] > weights[edge.from] + edge.weight) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[M + 1];
		long[] weights = new long[N + 1];

		Arrays.fill(weights, INF);

		for (int i = 1; i <= M; ++i) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(A, B, C);
		}

		boolean existCycle = bellmanFord(N, M, edges, weights);

		if (existCycle) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= N; ++i) {
				if (weights[i] == INF) {
					System.out.println(-1);
				} else {
					System.out.println(weights[i]);
				}
			}
		}
	}
}
