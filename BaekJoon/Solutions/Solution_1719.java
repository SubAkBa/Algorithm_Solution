import java.util.*;
import java.io.*;

public class dijkstra_1719_solution {
	static int vertex, edge, INF = 987654321;
	static int[][] graph, trace, output;
	static int[] dist;

	public static void Dijkstra(int start) {
		PriorityQueue<Graph> pq = new PriorityQueue<>();

		dist[start] = 0;
		pq.offer(new Graph(start, dist[start]));

		while (!pq.isEmpty()) {
			Graph from = pq.poll();

			if (from.dist > dist[from.idx])
				continue;

			for (int to = 1; to <= vertex; to++) {
				if (graph[from.idx][to] != INF) {
					if (dist[to] > dist[from.idx] + graph[from.idx][to]) {
						dist[to] = dist[from.idx] + graph[from.idx][to];
						pq.offer(new Graph(to, dist[to]));

						trace[start][to] = from.idx;
					}
				}
			}
		}

		for (int i = 1; i <= vertex; i++) {
			
			if (trace[start][i] == start)
				output[start][i] = i;
			else {
				int idx = i;
				int value = trace[start][idx];

				while (true) {
					idx = value;
					value = trace[start][idx];
					
					if(value == start || idx == value)
						break;
				}

				output[start][i] = idx;
			}
			
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		trace = new int[vertex + 1][vertex + 1];
		graph = new int[vertex + 1][vertex + 1];
		output = new int[vertex + 1][vertex + 1];
		dist = new int[vertex + 1];

		for (int i = 1; i <= vertex; i++) {
			for (int j = 1; j <= vertex; j++) {
				if (i == j)
					graph[i][j] = 0;
				else
					graph[i][j] = INF;
				trace[i][j] = 0;
			}
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			if (graph[from][to] > dist)
				graph[from][to] = graph[to][from] = dist;
		}

		for (int i = 1; i <= vertex; i++) {
			Arrays.fill(dist, INF);
			Dijkstra(i);
		}

		for (int i = 1; i <= vertex; i++) {
			for (int j = 1; j <= vertex; j++) {
				if (output[i][j] == 0)
					System.out.print("- ");
				else
					System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class Graph implements Comparable<Graph> {
	int idx, dist;

	public Graph(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}

	@Override
	public int compareTo(Graph g) {
		return dist <= g.dist ? -1 : 1;
	}
}