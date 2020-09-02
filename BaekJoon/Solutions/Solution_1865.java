import java.io.*;
import java.util.*;

public class Solution_1865 {
	static Edge[] edgelist;
	static int N, E, INF = 987654321;

	public static boolean WormHoll(int start) {
		boolean isCycle = false;
		int[] cost = new int[N + 1];

		Arrays.fill(cost, INF);
		
		cost[start] = 0;

		for (int iter = 1; iter <= N; iter++) {
			for (int e = 1; e <= E; e++) {
				Edge edge = edgelist[e];

				if (cost[edge.to] > cost[edge.from] + edge.cost) {
					cost[edge.to] = cost[edge.from] + edge.cost;

					if (iter == N)
						isCycle = true;
				}

			}
		}

		return isCycle;
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
		int T = Integer.parseInt(br.readLine());

		while ((T--) > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			E = 2 * M + W;

			edgelist = new Edge[E + 1];

			for (int i = 1; i <= E; i++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				if (i <= 2 * M) {
					edgelist[i++] = new Edge(from, to, cost);
					edgelist[i] = new Edge(to, from, cost);
				} else
					edgelist[i] = new Edge(from, to, -cost);
			}

			if (WormHoll(1))
				bw.write("YES\n");
			else
				bw.write("NO\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
