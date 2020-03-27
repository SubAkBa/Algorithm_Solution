import java.io.*;
import java.util.*;

public class Solution_1956 {
	static int[][] graph;
	static int V, INF = 987654321;

	public static void Exercise() {
		for (int via = 1; via <= V; via++) {
			for (int from = 1; from <= V; from++) {
				if (graph[from][via] == INF)
					continue;

				for (int to = 1; to <= V; to++) {
					if (graph[from][via] + graph[via][to] < graph[from][to])
						graph[from][to] = graph[from][via] + graph[via][to];
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		graph = new int[V + 1][V + 1];

		for (int i = 1; i <= V; i++)
			Arrays.fill(graph[i], INF);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[from][to] = cost;
		}

		Exercise();

		int result = INF;

		for (int i = 1; i <= V; i++)
			result = Math.min(result, graph[i][i]);

		if (result == INF)
			result = -1;
		
		bw.write(result + " ");
		bw.flush();
		bw.close();
		br.close();
	}

}
