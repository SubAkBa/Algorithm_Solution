import java.util.*;
import java.io.*;

public class dijkstra_1753_solution {
	static ArrayList<Graph>[] list;
	static int[] dist;
	static int vertex, edge, INF = 987654321;

	public static void Dijkstra(int start) {
		PriorityQueue<Graph> pq = new PriorityQueue<>();
		dist[start] = 0;

		pq.offer(new Graph(start, dist[start]));

		while (!pq.isEmpty()) {
			Graph from = pq.poll();

			if (from.dist > dist[from.idx])
				continue;

			for (int i = 0; i < list[from.idx].size(); i++) {
				Graph to = list[from.idx].get(i);
				
				if (dist[to.idx] > dist[from.idx] + to.dist) {
					dist[to.idx] = dist[from.idx] + to.dist;
					pq.offer(new Graph(to.idx, dist[to.idx]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());

		list = new ArrayList[vertex + 1];
		dist = new int[vertex + 1];

		Arrays.fill(dist, INF);

		for (int i = 1; i <= vertex; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			list[from].add(new Graph(to, dist));
		}

		Dijkstra(start);

		for (int i = 1; i <= vertex; i++) {
			if (dist[i] == INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
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
	public int compareTo(Graph o) {
		return (dist <= o.dist ? -1 : 1);
	}

}