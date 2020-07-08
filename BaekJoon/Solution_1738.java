import java.util.*;
import java.io.*;

public class Solution_1738 {
	static int n, m, INF = 987654321, INF2 = -987654321;
	static Edge[] edgelist;
	static ArrayList<Integer> answer;

	public static boolean Go_Alley() {
		int[] prev = new int[n + 1];
		int[] dist = new int[n + 1];

		Arrays.fill(dist, INF2);

		dist[1] = 0;
		prev[1] = 1;

		for (int iter = 1; iter <= n; ++iter) {
			for (int i = 0; i < m; ++i) {
				Edge edge = edgelist[i];

				if (dist[edge.from] == INF2)
					continue;

				if (dist[edge.to] >= dist[edge.from] + edge.cost)
					continue;

				dist[edge.to] = dist[edge.from] + edge.cost;
				prev[edge.to] = edge.from;

				if (iter == n)
					dist[edge.to] = INF;
			}
		}

		if (dist[n] == INF || dist[n] == INF2)
			return true;

		for (int i = n; i != 1; i = prev[i]) {
			if (dist[i] == INF)
				return true;

			answer.add(i);
		}

		answer.add(1);

		return false;
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
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		edgelist = new Edge[m];
		answer = new ArrayList<>();

		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edgelist[i] = new Edge(u, v, w);
		}

		if (Go_Alley())
			bw.write("-1");
		else {
			int size = answer.size();

			for (int i = size - 1; i >= 0; --i)
				bw.write(answer.get(i) + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
