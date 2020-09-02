import java.util.*;
import java.io.*;

public class Solution_11657 {
	static int N, M;
	static Edge[] edgelist;
	static long[] dist;

	public static boolean Time_Machine() {
		boolean updated = false;

		dist[1] = 0;

		for (int iter = 0; iter < N; iter++) {
			for (int i = 1; i <= M; i++) {
				Edge edge = edgelist[i];

				if (dist[edge.from] == Integer.MAX_VALUE)
					continue;

				if (dist[edge.to] > dist[edge.from] + edge.cost) {
					dist[edge.to] = dist[edge.from] + edge.cost;

					if (iter == N - 1)
						updated = true;
				}
			}
		}

		return updated;
	}

	public static class Edge {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dist = new long[N + 1];
		edgelist = new Edge[M + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edgelist[i] = new Edge(from, to, cost);
		}

		if (Time_Machine())
			bw.write("-1\n");
		else {
			for (int i = 2; i <= N; i++)
				bw.write((dist[i] == Integer.MAX_VALUE ? -1 : dist[i]) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
