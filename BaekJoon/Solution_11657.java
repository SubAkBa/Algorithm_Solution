import java.io.*;
import java.util.*;

public class Solution_11657 {
	static Edge[] edgelist;
	static int[] cost;
	static int N, M, INF = 987654321;

	public static boolean TimeMachine(int start) {
		boolean updated = false;
		cost[start] = 0;

		for (int iter = 1; iter <= N; iter++) {
			updated = false;

			for (int e = 1; e <= M; e++) {
				Edge edge = edgelist[e];

				if (cost[edge.from] == INF)
					continue;

				if (cost[edge.to] > cost[edge.from] + edge.cost) {
					cost[edge.to] = cost[edge.from] + edge.cost;
					updated = true;
				}
			}

			if (!updated)
				break;
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

		cost = new int[N + 1];
		edgelist = new Edge[M + 1];

		Arrays.fill(cost, INF);

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edgelist[i] = new Edge(from, to, cost);
		}

		if (TimeMachine(1))
			bw.write("-1");
		else {
			for (int i = 2; i <= N; i++) {
				if (cost[i] == INF)
					bw.write("-1\n");
				else
					bw.write(cost[i] + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
