import java.util.*;
import java.io.*;

public class bellmanford_11657_solution {
	static int N, M, INF = 987654321;
	static int[] dist;

	public static void Bellman_Ford(Graph graph, int start) {
		boolean isCycle = false;

		dist[start] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				Edge temp = graph.edge[j];

				if (dist[temp.from] == INF)
					continue;

				if (dist[temp.to] > dist[temp.from] + temp.weight) {
					dist[temp.to] = dist[temp.from] + temp.weight;
					
					if(i == N)
						isCycle = true;
				}
			}
		}

		if (isCycle)
			System.out.println("-1");
		else {
			for (int i = 2; i <= N; i++)
				System.out.println((dist[i] == INF) ? -1 : dist[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N + 1];
		Graph graph = new Graph(N, M);

		Arrays.fill(dist, INF);

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.edge[i] = new Edge(from, to, weight);
		}

		Bellman_Ford(graph, 1);
	}

}

class Edge {
	int from, to, weight;

	public Edge() {
		from = to = weight = 0;
	}

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

class Graph {
	int V, E;
	Edge[] edge;

	public Graph(int V, int E) {
		this.V = V;
		this.E = E;

		edge = new Edge[E + 1];

		for (int i = 1; i <= E; i++)
			edge[i] = new Edge();
	}
}